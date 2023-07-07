package com.Test;


import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Reports_Employee_Role_Based_Payroll_Report_Formula 
{
	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Employee - Role Based Payroll Report (Formula) ");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	double CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip,OverAll_Tip,Over_All_Pay,OverAll_Tip_Dly,Over_All_Pay_Dly,OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Dly,Tip_Shared_Wly;
	float unknownValue = 00;
	String Child_tab, parent_tab;
	ArrayList<String> Alltabs;

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
	

@Test(priority=1)
public void login() throws Exception
{
	Thread.sleep(2000);
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
	
@Test(priority=500)
public void logout() throws Exception
{	
	a.LogOut(driver, test);
}
	
@Test(priority = 100)
public void calling() throws Exception
{
	Thread.sleep(1000);
	try
	{
Thread.sleep(1000);System.out.println("Minimize Chat Icon");
driver.findElement(By.id("zsiq_minimize")).click();
	}
	catch(Exception e)
	{
	System.out.println("Minimize Chat Icon Missing");
	}
	//ViewDashBoardReports a = new ViewDashBoardReports(); 
	Thread.sleep(1000);
	Employee_Role_Based_Payroll_Report_Method_Page_Open(driver);
//	Enable_and_Verify_All_button(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(driver); 
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(driver);
	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable(driver);
	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisable(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_DisableAndEnable_Online_pickup_Tip(driver); 
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisableAndEnable_Online_pickup_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_DisableAndEnable_declared_cash_tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisableAndEnable_declared_cash_tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable_Enable_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_All_Disable_Enable_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable_Enable_DrivComp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_All_Disable_Enable_DrivComp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Gratuity_Disable_Drivercomp_Enable_OLOPickuptip_Enable_Declcashtip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Gratuity_Disable_Drivercomp_Enable_OLOPickuptip_Enable_Declcashtip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_PckUp_Tip_Disable_Drivercomp_Enable_Decl_Cash_Tip_Enable_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_PckUp_Tip_Disable_Drivercomp_Enable_Decl_Cash_Tip_Enable_Gratuity(driver);	
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Driver_Comp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Driver_Comp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Driver_Comp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Driver_Comp(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Gratuity(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Decl_Cash_Tip(driver);
//	Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Decl_Cash_Tip(driver);

	
	Thread.sleep(1500);
}

@Test(priority=50,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_Page_Open(WebDriver driver) throws Exception
{
	
	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(5000);
	//Load the Employee Attendance Report Page
	driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"employee/roleBasedPayroll");

	Thread.sleep(5000);
	//Verify the Employee Attendance Report Page loaded or not
	repts.Verify_ReportHomePage("ROLE BASED PAYROLL");

}

//	@Test(priority = 51,enabled = false)
//	public void Enable_and_Verify_All_button(WebDriver driver) throws Exception
//	{
//	
//	 	
//	repts=new ReportsPage(driver, test);
//	cmp=new Common_XPaths(driver, test);
//	
//	
//	
//	
//	
//	
//	
//
//	((JavascriptExecutor)driver).executeScript("window.open()");
//	ArrayList<String> Alltabs=new ArrayList<String>(driver.getWindowHandles());
//	this.Alltabs=Alltabs;
//	driver.switchTo().window(Alltabs.get(3));
//	driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"newTipOutTipSharingSettings");
//
//	Thread.sleep(3000);
//	
//	//Check whether the Online Pickup Tip is Enabled or not
//	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
//	{
//
//	}
//	else
//	{
//driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
//	}
//	
//	
//	
//	//Check whether the Online Pickup Tip is Enabled or not
//	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
//	{
//
//	}
//	else
//	{
//driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
//	}
//	
//	//Check whether the Online Pickup Tip is Enabled or not
//	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
//	{
//
//	}
//	else
//	{
//driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
//	}
//	
//	//Check whether the Online Pickup Tip is Enabled or not
//	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
//	{
//
//	}
//	else
//	{
//driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
//	}
//	
//	try
//	{
//	//Click the Update button
//	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
//	}
//	catch(Exception k) {}
//	Thread.sleep(2000);
//	
//	//Click Publish button
//	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
//	Thread.sleep(5000);
//	
//	driver.switchTo().window(Alltabs.get(2));
//	
//	Thread.sleep(1000);
//	//Select the Employee option
//	
//	
//	repts.Select_Employee("All");
//	
//	
//	
//	Thread.sleep(1000);
//	//Select the Process as Daily
//	
//	repts.Select_Process("Daily");   
//	
//  	
//	//Select the Date Range
//	
//	
//	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
//	
//	
//	
//	Thread.sleep(1000);
//	
//	
//	
//	
//	
//	Thread.sleep(1000);
//	
//	
//	
//	
//	  
//	
//	
//	//Select the Format
//	repts.Select_FormatType("In Time");
//	
//	
//	  
//	
//	
//	//Select the Format
//	repts.Select_Status("All");
//	
//	
//	
//	Thread.sleep(1000);
//	//Select the Process as Daily
//
//repts.Select_Sort_By("A-Z FirstName");
//
//	
//	
//	//Select the Role
//	repts.Select_Role("All");
//	
//	
//	
//	//Click Apply
//	repts.Click_ApplyButton(); 
//	Thread.sleep(30000);
//	   
//	
//	//Check weather the report is available for the selected time period
//	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
//	{
//	test.log(LogStatus.FAIL, "Employee Payroll Report is not available");
//	
//	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//	String s="data:image/png;base64,"+scnShot;
//	test.log(LogStatus.INFO,test.addScreenCapture(s));
//	
//	}
//
//	else
//	{
//	
//	test.log(LogStatus.PASS, "Employee Payroll Report is Available");
//	
//	System.out.println("******* Toggle Validation *******");
//	
//	test.log(LogStatus.INFO, "******* Toggle Validation *******");
//	
//	//Click the Column Add Toggle to Enable 
//	driver.findElement(By.xpath(excel.getData(3, 221, 1))).click();
//	
//	 
//	Thread.sleep(2000);
//	//Check whether the Emp ID Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2417, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Employee ID Toggle Available on the Report");
//	
//	//Check whether the Employee ID enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2417, 1))).isEnabled())
//	{
////Check whether the Employee ID Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2539, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Employee ID Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Employee ID Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Employee ID 
//driver.findElement(By.xpath(excel.getData(3, 2433, 1))).click();
//

////Check whether the Employee ID Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2539, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Employee ID Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Employee ID Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//test.log(LogStatus.FAIL, "Employee ID Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Role ID Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2537, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Role ID Toggle Available on the Report");
//	
//	//Check whether the Role ID enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2537, 1))).isEnabled())
//	{
////Check whether the Role ID Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2540, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Role ID Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Role ID Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Role ID 
//driver.findElement(By.xpath(excel.getData(3, 2538, 1))).click();
//

////Check whether the Role ID Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2540, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Role ID Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Role ID Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//test.log(LogStatus.FAIL, "Role ID Toggle Not Available on the Report");
//	
//	}
//	
//	
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Pay Rate Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2541, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Pay Rate Toggle Available on the Report");
//	
//	//Check whether the Pay Rate enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2541, 1))).isEnabled())
//	{
////Check whether the Pay Rate Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2543, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Pay Rate Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Pay Rate Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Pay Rate
//driver.findElement(By.xpath(excel.getData(3, 2542, 1))).click();
//

////Check whether the Pay Rate Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2543, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Pay Rate Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Pay Rate Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//test.log(LogStatus.FAIL, "Pay Rate Toggle Not Available on the Report");
//	
//	}
//	
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Reg Pay Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2544, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Reg Pay Toggle Available on the Report");
//	
//	//Check whether the Reg Pay enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2544, 1))).isEnabled())
//	{
////Check whether the Reg Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2545, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Reg Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Reg Pay Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Reg Pay
//driver.findElement(By.xpath(excel.getData(3, 2546, 1))).click();
//

////Check whether the Reg Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2545, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Reg Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Reg Pay Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Reg Pay Toggle Not Available on the Report");
//	
//	}
//	
//	
//	
//	
//	
//	Thread.sleep(2000);
//	//Check whether the OT Pay Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2547, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "OT Pay Toggle Available on the Report");
//	
//	//Check whether the OT Pay enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2547, 1))).isEnabled())
//	{
////Check whether the OT Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2548, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "OT Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "OT Pay Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the OT Pay
//driver.findElement(By.xpath(excel.getData(3, 2549, 1))).click();
//

////Check whether the OT Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2548, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "OT Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "OT Pay Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "OT Pay Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the TTL Hrs Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2550, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "TTL Hrs Toggle Available on the Report");
//	
//	//Check whether the TTL Hrs enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2550, 1))).isEnabled())
//	{
////Check whether the TTL Hrs Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2551, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Hrs Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Hrs Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the TTL Hrs
//driver.findElement(By.xpath(excel.getData(3, 2552, 1))).click();
//

////Check whether the TTL Hrs Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2551, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Hrs Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Hrs Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "TTL Hrs Toggle Not Available on the Report");
//	
//	}
//	
//
//	
//	Thread.sleep(2000);
//	//Check whether the TTL Pay Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2553, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "TTL Pay Toggle Available on the Report");
//	
//	//Check whether the TTL Pay enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2553, 1))).isEnabled())
//	{
////Check whether the TTL Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2554, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Pay Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the TTL Pay
//driver.findElement(By.xpath(excel.getData(3, 2555, 1))).click();
//

////Check whether the TTL Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2554, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Pay Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "TTL Pay Toggle Not Available on the Report");
//	
//	}
//	
//	Thread.sleep(2000);
//	//Check whether the CC Tip Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2556, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "CC Tip Toggle Available on the Report");
//	
//	//Check whether the CC Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2556, 1))).isEnabled())
//	{
////Check whether the CC Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2557, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "CC Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "CC Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the CC Tip
//driver.findElement(By.xpath(excel.getData(3, 2558, 1))).click();
//

////Check whether the CC Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2557, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "CC Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "CC Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "CC Tip Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Charge Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2559, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Charge Toggle Available on the Report");
//	
//	//Check whether the Tip Charge enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2559, 1))).isEnabled())
//	{
////Check whether the Tip Charge Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2560, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Charge Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Charge Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Tip Charge
//driver.findElement(By.xpath(excel.getData(3, 2561, 1))).click();
//

////Check whether the Tip Charge Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2560, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Charge Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Charge Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Charge Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Emp CC Tip Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2562, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Emp CC Tip Toggle Available on the Report");
//	
//	//Check whether the Tip Charge enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2562, 1))).isEnabled())
//	{
////Check whether the Emp CC Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2563, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Emp CC Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Emp CC Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Emp CC Tip
//driver.findElement(By.xpath(excel.getData(3, 2564, 1))).click();
//

////Check whether the Emp CC Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2563, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Emp CC Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Emp CC Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Emp CC Tip Toggle Not Available on the Report");
//	
//	}
//	
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Out Cont Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2565, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Out Cont Toggle Available on the Report");
//	
//	//Check whether the Tip Out Cont enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2565, 1))).isEnabled())
//	{
////Check whether the Tip Out Cont Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2566, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Cont Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Cont Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable the Tip Out Cont
//driver.findElement(By.xpath(excel.getData(3, 2567, 1))).click();
//

////Check whether the Tip Out Cont Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2566, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Cont Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Cont Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Out Cont Toggle Not Available on the Report");
//	
//	}
//	
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Gratuity Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2568, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Gratuity Toggle Available on the Report");
//	
//	//Check whether the Gratuity enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2568, 1))).isEnabled())
//	{
////Check whether the Gratuity Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2569, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Gratuity Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Gratuity Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Gratuity
//driver.findElement(By.xpath(excel.getData(3, 2570, 1))).click();
//

////Check whether the Gratuity Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2569, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Gratuity Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Gratuity Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Gratuity Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Other Tips Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2571, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Other Tips Toggle Available on the Report");
//	
//	//Check whether the Other Tips enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2571, 1))).isEnabled())
//	{
////Check whether the Other Tips Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2572, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Other Tips Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Other Tips Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Other Tips
//driver.findElement(By.xpath(excel.getData(3, 2573, 1))).click();
//

////Check whether the Other Tips Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2572, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Other Tips Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Other Tips Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Other Tips Toggle Not Available on the Report");
//	
//	}
//	
//try
//{
//	Thread.sleep(2000);
//	//Check whether the OLO Pkup Tip Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2665, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "OLO Pkup Tip Toggle Available on the Report");
//	
//	//Check whether the OLO Pkup Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2665, 1))).isSelected())
//	{
////Check whether the OLO Pkup Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2666, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "OLO Pkup Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "OLO Pkup Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable OLO Pkup Tip
//driver.findElement(By.xpath(excel.getData(3, 2667, 1))).click();
//

////Check whether the OLO Pkup Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2666, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "OLO Pkup Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "OLO Pkup Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "OLO Pkup Tip Toggle Not Available on the Report");
//	
//	}
//	
//	Thread.sleep(2000);
//	//Check whether the DRV Comp Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2668, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "DRV Comp Toggle Available on the Report");
//	
//	//Check whether the DRV Comp enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2668, 1))).isSelected())
//	{
////Check whether the DRV Comp Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2669, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "DRV Comp Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "DRV Comp Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable DRV Comp
//driver.findElement(By.xpath(excel.getData(3, 2670, 1))).click();
//

////Check whether the DRV Comp Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2669, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "DRV Comp Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "DRV Comp Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "DRV Comp Toggle Not Available on the Report");
//	
//	}
//}
//catch(Exception gh) {}
//	Thread.sleep(2000);
//	//Check whether the Decl Tips Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2574, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Decl Tip Toggle Available on the Report");
//	
//	//Check whether the Decl Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2574, 1))).isEnabled())
//	{
////Check whether the Decl Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2575, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Decl Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Decl Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Decl Tip
//driver.findElement(By.xpath(excel.getData(3, 2576, 1))).click();
//

////Check whether the Decl Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2575, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Decl Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Decl Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Decl Tip Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the TTL Tips Toggle Available or not
//	/*	if(driver.findElement(By.xpath(excel.getData(3, 2577, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "TTL Tip Toggle Available on the Report");
//	
//	//Check whether the TTL Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2577, 1))).isEnabled())
//	{
////Check whether the TTL Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2578, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable TTL Tip
//driver.findElement(By.xpath(excel.getData(3, 2579, 1))).click();
//

////Check whether the TTL Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2578, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "TTL Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "TTL Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "TTL Tip Toggle Not Available on the Report");
//	
//	}*/
//	
//
//	Thread.sleep(2000);
//	//Check whether the Net Sales Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2580, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Net Sales Toggle Available on the Report");
//	
//	//Check whether the Net Sales enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2580, 1))).isEnabled())
//	{
////Check whether the Net Sales Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2581, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Net Sales Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Net Sales Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Net Sales
//driver.findElement(By.xpath(excel.getData(3, 2582, 1))).click();
//

////Check whether the Net Sales Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2581, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Net Sales Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Net Sales Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Net Sales Toggle Not Available on the Report");
//	
//	}
//	
//	
//
//	Thread.sleep(2000);
//	//Check whether the Exp Tip Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2583, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Exp Tip Toggle Available on the Report");
//	
//	//Check whether the Exp Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2583, 1))).isEnabled())
//	{
////Check whether the Exp Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2584, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Exp Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Exp Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Exp Tip
//driver.findElement(By.xpath(excel.getData(3, 2585, 1))).click();
//

////Check whether the Exp Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2584, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Exp Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Exp Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Exp Tip Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Shared Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2586, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Shared Toggle Available on the Report");
//	
//	//Check whether the Tip Shared enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2586, 1))).isEnabled())
//	{
////Check whether the Tip Shared Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2587, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Shared Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Shared Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Tip Shared
//driver.findElement(By.xpath(excel.getData(3, 2588, 1))).click();
//

////Check whether the Tip Shared Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2587, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Shared Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Shared Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Shared Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Adj Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2589, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Shared Toggle Available on the Report");
//	
//	//Check whether the Tip Adj enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2589, 1))).isSelected())
//	{
////Check whether the Tip Adj Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2590, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Adj Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Adj Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Tip Adj
//driver.findElement(By.xpath(excel.getData(3, 2591, 1))).click();
//

////Check whether the Tip Adj Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2590, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Adj Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Adj Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Adj Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Out Shared Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2592, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Out Shared Toggle Available on the Report");
//	
//	//Check whether the Tip Out Shared enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2592, 1))).isSelected())
//	{
////Check whether the Tip Out Shared Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2593, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Shared Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Shared Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Tip Out Shared
//driver.findElement(By.xpath(excel.getData(3, 2594, 1))).click();
//

////Check whether the Tip Out Shared Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2593, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Shared Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Shared Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Out Shared Toggle Not Available on the Report");
//	
//	}
//	
//	
//	Thread.sleep(2000);
//	//Check whether the Tip Out Adj Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2595, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Tip Out Adj Toggle Available on the Report");
//	
//	//Check whether the Tip Out Adj enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2595, 1))).isSelected())
//	{
////Check whether the Tip Out Adj Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2596, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Adj Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Adj Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Tip Out Adj
//driver.findElement(By.xpath(excel.getData(3, 2597, 1))).click();
//

////Check whether the Tip Out Adj Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2596, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Tip Out Adj Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Tip Out Adj Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Tip Out Adj Toggle Not Available on the Report");
//	
//	}
//	
//	Thread.sleep(2000);
//	//Check whether the Over All Tip Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2598, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Over All Tip Toggle Available on the Report");
//	
//	//Check whether the Over All Tip enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2598, 1))).isSelected())
//	{
////Check whether the Over All Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2599, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Over All Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Over All Tip Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Over All Tip
//driver.findElement(By.xpath(excel.getData(3, 2600, 1))).click();
//

////Check whether the Over All Tip Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2599, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Over All Tip Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Over All Tip Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Over All Tip Toggle Not Available on the Report");
//	
//	}
//	
//	Thread.sleep(2000);
//	//Check whether the Overall Pay Toggle Available or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2671, 1))).isDisplayed())
//	{
//test.log(LogStatus.PASS, "Overall Pay Toggle Available on the Report");
//	
//	//Check whether the Overall Pay enabled or not
//	if(driver.findElement(By.xpath(excel.getData(3, 2671, 1))).isSelected())
//	{
////Check whether the Overall Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2672, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Overall Pay Column Displayed on the Report");
//	
//}
//else
//{
//	test.log(LogStatus.FAIL, "Overall Pay Column Not Displayed on the Report");
//}
//	}
//	else
//	{

////Enable Overall Pay
//driver.findElement(By.xpath(excel.getData(3, 2673, 1))).click();
//

////Check whether the Overall Pay Column Displayed or not
//if(driver.findElement(By.xpath(excel.getData(3, 2672, 1))).isDisplayed())
//{
//	test.log(LogStatus.PASS, "Overall Pay Column Displayed on the Report");
//}
//else
//{
//	test.log(LogStatus.FAIL, "Overall Pay Column Not Displayed on the Report");
//}
//	}
//	}
//	else
//	{
//	test.log(LogStatus.FAIL, "Overall Pay Toggle Not Available on the Report");
//	
//	}
//	
//	}
//	 
//	
//	}

	@Test(priority=52,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(WebDriver driver) throws Exception
	{
	double CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip,OverAll_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	Thread.sleep(1000);

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	
	//Select the Today
	repts.Select_Today_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");

	//Select the Format
	repts.Select_Status("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");

	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(40000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date (Daily -Today)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date (Daily -Today)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily - Today) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily - Today) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=53,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	 
	 	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Weekly");   
	
	//Select the Date Range
	repts.Select_Today_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date (Weekly -Today)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date (Weekly -Today)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time((Weekly -Today)) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time((Weekly -Today)) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Today : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Today : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Today  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Today)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Today). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Today : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Today  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Today)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Today). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Today : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Today  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Today : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Today  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Today : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Today  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Today : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Today  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Today)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Today : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Today  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Today : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Today  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Today)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Today : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Today  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Today : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Today  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Today : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Today  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Today : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Today  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Today : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Today  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
}
	
	


	}
	
	@Test(priority=54,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Daily");   
	
	//Select the Yesterday
	repts.Select_Yesterday_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");

	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date (Daily -Yesterday)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date (Daily -Yesterday)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time((Daily -Yesterday)) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time((Daily -Yesterday)) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}

	
	}
	
	@Test(priority=55,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Weekly");   

	
	repts.Select_Yesterday_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Yesterday : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Yesterday : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Yesterday  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Yesterday)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Yesterday). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Yesterday : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Yesterday  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Yesterday)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Yesterday). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Yesterday : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Yesterday  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Yesterday : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Yesterday  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Yesterday : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Yesterday  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Yesterday : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Yesterday  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Yesterday)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Yesterday : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Yesterday  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Yesterday : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Yesterday  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Yesterday : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Yesterday  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Yesterday : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Yesterday  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Yesterday : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Yesterday  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Yesterday : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Yesterday  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Yesterday : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Yesterday  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
}
	
	
	

	}

	
	@Test(priority=56,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Date Range
	repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(60000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=57,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Weekly");   
	
  	
	//Select the Last N Days
	repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last N days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last N days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last N days  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last N days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last N days). Diff is : "+diff);
	}
	 
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last N days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last N days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last N days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last N days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last N days : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last N days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last N days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last N days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last N days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last N days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last N days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last N days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last N days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last N days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last N days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last N days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last N days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last N days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last N days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last N days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last N days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last N days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last N days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last N days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last N days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last N days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last N days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last N days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
}


	
	}
	
	
	@Test(priority=58,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Date Range
	repts.Select_This_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}



	}
	
	@Test(priority=59,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(WebDriver driver) throws Exception
	{

		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Weekly");   
	
  	//Select the Date Range
	repts.Select_This_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily This Week : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily This Week : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in This Week  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-This Week)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-This Week). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily This Week : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in This Week  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-This Week)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-This Week). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily This Week : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in This Week  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily This Week : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in This Week  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily This Week : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in This Week  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily This Week : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in This Week  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (This Week)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily This Week : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in This Week  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily This Week : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in This Week  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (This Week)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily This Week : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in This Week  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily This Week : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in This Week  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily This Week : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in This Week  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily This Week : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in This Week  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily This Week : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in This Week  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
}
	

	}

	@Test(priority=60,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	repts.Select_Last_Week_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=61,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
		Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Weekly");   
	
 	//Select the Date Range
	repts.Select_Last_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");

	//Select the Format
	repts.Select_Status("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last Week : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last Week : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last Week  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last Week)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last Week). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last Week : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last Week  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last Week)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last Week). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last Week : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last Week  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last Week : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last Week  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last Week : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last Week  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last Week : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last Week  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last Week)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last Week : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last Week  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last Week : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last Week  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last Week)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last Week : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last Week  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last Week : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last Week  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last Week : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last Week  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last Week : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last Week  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last Week : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last Week  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
}

	}

	@Test(priority=62,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	//Select the Last 7 days
	repts.Select_Last_7_Days_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=63,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Weekly");   
	
	//Select the Last 7days
	repts.Select_Last_7_Days_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last 7 days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last 7 days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last 7 days  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last 7 days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last 7 days). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last 7 days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last 7 days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last 7 days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last 7 days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last 7 days : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last 7 days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last 7 days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last 7 days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last 7 days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last 7 days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last 7 days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last 7 days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last 7 days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last 7 days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last 7 days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last 7 days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last 7 days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last 7 days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last 7 days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last 7 days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last 7 days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last 7 days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last 7 days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last 7 days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last 7 days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last 7 days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last 7 days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
}	
	
	

	}

	
	@Test(priority=64,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);


	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Daily");   
	
  	//Select the Date Range
	repts.Select_This_Month_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=65,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Weekly");   
	
  	//Select the This Month
	repts.Select_This_Month_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily This Month : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily This Month : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in This Month : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-This Month)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-This Month). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily This Month : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in This Month  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-This Month)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-This Month). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily This Month: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in This Month  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily This Month : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in This Month  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily This Month : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in This Month  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily This Month : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in This Month  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (This Month)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily This Month : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in This Month  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily This Month : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in This Month  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (This Month)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily This Month : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in This Month  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily This Month : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in This Month  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily This Month : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in This Month  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily This Month : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in This Month  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily This Month : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in This Month  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
}	
	
	

	}

	@Test(priority=66,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Last Month	
	repts.Select_Last_Month_TimePeriod();
		
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=67,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Weekly");   
	
	//Select the Last Month
	repts.Select_Last_Month_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last Month : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last Month : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last Month : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last Month)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last Month). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last Month : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last Month  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last Month)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last Month). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last Month: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last Month  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last Month : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last Month  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last Month : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last Month  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last Month : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last Month  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last Month)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last Month : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last Month  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last Month : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last Month  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last Month)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last Month : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last Month  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last Month : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last Month  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last Month : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last Month  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last Month : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last Month  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last Month : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last Month  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
}	
	
	

	}
	
	
	@Test(priority=68,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	  	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  //Select the Last 30 days
	repts.Select_Last_30_Days_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=69,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(WebDriver driver) throws Exception
	{


	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	  	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Weekly");   
	
 	//Select the Date Range
	repts.Select_Last_30_Days_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last 30 days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last 30 days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last 30 days : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last 30 days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last 30 days). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last 30 days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last 30 days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last 30 days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last 30 days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last 30 days: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last 30 days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last 30 days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last 30 days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last 30 days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last 30 days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last 30 days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last 30 days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last 30 days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last 30 days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last 30 days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last 30 days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last 30 days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last 30 days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last 30 days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last 30 days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last 30 days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last 30 days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last 30 days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last 30 days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last 30 days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last 30 days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last 30 days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
}	
	
	

	}


	
	@Test(priority=70,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
 	//Select the Specific date
	repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
	
	Thread.sleep(1000);
	//To Get Employee List
	List<WebElement> empList=driver.findElements(By.xpath("//tr[@style='background-color:']/td[@data-title-text='Role']/div"));
	
	for(WebElement empEach:empList)
	{
	Thread.sleep(2000);
	if(empEach!=null)
	{
test.log(LogStatus.PASS, "Role Name Available");

Thread.sleep(1500);
String EmpName=empEach.getText();
//String str=EmpName.substring(1, EmpName.length()-1);

try
{
String empRollinSummary=driver.findElement(By.xpath("//td[contains(.,'"+EmpName+" - Summary')]/../td[@data-title-text='Role ID']/div")).getText();

if(empRollinSummary!=null)
{
	test.log(LogStatus.PASS, "Role ID Displayed in Summary. Displayed Role Name : "+empRollinSummary+" Role ID is : "+empRollinSummary);
}
}
catch(Exception lk)
{
	test.log(LogStatus.FAIL, "Role ID not Displayed in Summary");
}

	}
	else
	{
test.log(LogStatus.FAIL, "Role Name not available");
	}
	
	
	
	}
	
	
	
	
}


	}
	
	@Test(priority=71,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	Thread.sleep(2000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Weekly");   
	
  //Select the Specific date
	repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily - Specific Date : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily - Specific Date : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in - Specific Date: "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly- Specific Date)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly- Specific Date). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily - Specific Date : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in - Specific Date  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly- Specific Date)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-- Specific Date). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily- Specific Date: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly - Specific Date  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily - Specific Date : "+CC_Tip);

	System.out.println("CC Tip values for Weekly - Specific Date  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily - Specific Date : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly - Specific Date  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily - Specific Date : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly - Specific Date  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (- Specific Date)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily - Specific Date : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly - Specific Date  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily - Specific Date : "+Other_Tip);

	System.out.println("Other Tip values for Weekly - Specific Date  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily - Specific Date : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly - Specific Date  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily - Specific Date : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly - Specific Date : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily - Specific Date : "+Net_Sales);

	System.out.println("Net Sales values for Weekly - Specific Date  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily - Specific Date : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly - Specific Date  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily - Specific Date : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly - Specific Date  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
}	
	
	
	
	
	//To Get Employee List
	List<WebElement> empList=driver.findElements(By.xpath("//tr[@style='background-color:']/td[@data-title-text='Role']/div"));
	
	for(WebElement empEach:empList)
	{
	if(empEach!=null)
	{
test.log(LogStatus.PASS, "Role Name Available");

String EmpName=empEach.getText();
//String str=EmpName.substring(1, EmpName.length()-1);

String empRollinSummary=driver.findElement(By.xpath("//td[contains(.,'"+EmpName+" - Summary')]/../td[@data-title-text='Role ID']/div")).getText();

if(empRollinSummary!=null)
{
	test.log(LogStatus.PASS, "Role ID Displayed in Summary. Displayed Role Name : "+empRollinSummary+" Role ID is : "+empRollinSummary);
}
else
{
	test.log(LogStatus.FAIL, "Role ID not Displayed in Summary");
}

	}
	else
	{
test.log(LogStatus.FAIL, "Role Name not available");
	}
	
	
	
	}
	
	
	

	}
	
	
	@Test(priority=72,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(WebDriver driver) throws Exception
	{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	
	
	
	
	
	
	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range Starts");
	
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(2000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
//	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range End");
Thread.sleep(1000);


	}
	@Test(priority=73,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	 	
	
	
	
	
	
	
	

	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range Starts");
	Thread.sleep(3000);
/*	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));

	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

Thread.sleep(2000);
//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Process("Daily");   
	
	  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
  


//Select the Format
repts.Select_FormatType("In Hours");


  


//Select the Format
repts.Select_Status("All");


	
Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Sort_By("Z-A FirstName");   



//Select the Role
repts.Select_Role("All");



//Click Apply
repts.Click_ApplyButton(); 
Thread.sleep(30000);
   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));
	}
	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Hours(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Daily) *******");
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(1000);
//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
/*	//Get Per Rate value
	String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/	
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double RegPayDt=Double.parseDouble(TotalRegPayDt);

	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
double Different=Expected_TTTLPayDt-Actual_TTLPayDt;

test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);

System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Total Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	
	
	//To Get the Cash Tip Percentage
/*	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

	//To Calculate Expected Cash Tip
	 double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
//	Expected_Cash_Tip=Expected_Cash_Tip/Emp_Count;
	
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
	
	
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	BigDecimal dd=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd.doubleValue();*/
	
	if(Expected_Tip==Actual_ExpectedTipDt)
	{
test.log(LogStatus.PASS, "Expected Tip Calculated successfully");
	}
	else
	{
double ExpectedTip_Difference=Expected_Tip-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	
	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
	test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	if(Tip_Shared_Dly==Actual_Tip_SharedDt)
	{
test.log(LogStatus.PASS, "Tip Shared is Correct for both In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double Tip_Shared_Diff=Tip_Shared_Dly-Actual_Tip_SharedDt;
test.log(LogStatus.FAIL, "Tip Shared is InCorrect for both In Time to In Hours (Date Range - Daily). The Values Difference is : "+Tip_Shared_Diff);
	}
	
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	double Actual_OverAll_Tip=Double.parseDouble(Actual_OverAllTip_Dt);
	
	if(OverAll_Tip_Dly==Actual_OverAll_Tip) 
	{
test.log(LogStatus.PASS, "Over All Tip Calculated correctly for In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double diff=OverAll_Tip_Dly-Actual_OverAll_Tip;
test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly for In Time to In Hours (Date Range - Daily). Diff is : "+diff);
	}
	
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	double Actual_Over_All_Pay=Double.parseDouble(Actual_OverAllPay_Dt);
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Over_All_Pay_Dly==Actual_Over_All_Pay) 
	{
test.log(LogStatus.PASS, "Over All Pay Calculated correctly for In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double diff=Over_All_Pay_Dly-Actual_Over_All_Pay;
test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly for In Time to In Hours (Date Range - Daily). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s2="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s2));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();

String[] name = namess.split(" ");
//System.out.println("TEST Z-A FIRST : "+name[0]);
obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
sortedList.add(s);
	}
	Collections.reverse(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
if(sortedList.equals(obtainedList))
{
	
}else
{
	test.log(LogStatus.FAIL, "Name sort is not working  for Z-A First Name");
}
	}
	
	/*	ArrayList<String> obtainedList = new ArrayList<>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(WebElement we:elementList){
	   obtainedList.add(we.getText());
	}
	ArrayList<String> sortedList = new ArrayList<>();   
	for(String s:obtainedList){ 
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	Assert.assertTrue(sortedList.equals(obtainedList));*/
	}	
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000); 
	
	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range End");

	}
	
	
	@Test(priority=74,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(2000);
	
	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range Starts");
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(5000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	//Select the Process as Daily
	repts.Select_Process("Weekly");

 	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z LastName");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


//Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range End");
	

	}
	@Test(priority=75,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(WebDriver driver) throws Exception
	{
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	
	Thread.sleep(5000);
	test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range Starts");
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");
 
	for(int i = 1; i <= 4; i++)
	{
Thread.sleep(2000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
Thread.sleep(3000);
	}
	
	Thread.sleep(1000);
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Hours");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Sort By
	
	repts.Select_Sort_By("Z-A LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	   	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Weekly) *******");

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);


Thread.sleep(1000);
List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
//Get Summary

/*String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);

//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

//Get Reg Pay
String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPay);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPay=Double.parseDouble(TotalRegPay);
	

//Get OT Pay
String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPay);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPay=Double.parseDouble(TotalOTPay);


//To Get Expected Total Pay
double Expected_TTTLPay=RegPay+OTPay;


//Get TTL Pay
String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPay);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPay=Double.parseDouble(TotalPay);


if(Expected_TTTLPay==Actual_TTLPay)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPay-Actual_TTLPay;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTip);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
double CC_Tip=Double.parseDouble(ccTip);
 

//Get Tip Charge Tip
String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+Tipcharge);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
double Tip_Charge=Double.parseDouble(Tipcharge);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_Tip=CC_Tip-Tip_Charge;


//Get Gratuity
String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuity);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
double Gratuity=Double.parseDouble(gratuity);

//Get Emp CC Tip
String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
double Actual_Emp_CC_Tip=Double.parseDouble(Emp_cc_tip);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_Tip==Actual_Emp_CC_Tip)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_Tip-Actual_Emp_CC_Tip;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTips);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
double Other_Tips=Double.parseDouble(otherTips);



//Get Declared Cash Tip
String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
double DeclaredCashTip=Double.parseDouble(declaredCashTip);



//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltip);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
double Actual_TTLTip=Double.parseDouble(ttltip);

//To Calculate Expected Total Tip
double Expected_TTLTip=CC_Tip+Gratuity+Other_Tips+DeclaredCashTip;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTip==Actual_TTLTip)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTip-Actual_TTLTip;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSales);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
double NetSales=Double.parseDouble(netSales);

//Get Expected Tip
String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTip);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
double Actual_ExpectedTip=Double.parseDouble(expectedTip);


//To Get the Cash Tip Percentage
	/*	String Cash_Tip_Per=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_Percentage=Double.parseDouble(Cash_Tip_Per);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

//To Calculate Expected Cash Tip
double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/100;
	//	Expected_Cash_Tip=Expected_Cash_Tip/Emp_Count;

System.out.println("Expected Cash Tip is : "+Expected_Cash_Tip);

//To Calculate No Cash Tip
double No_Cash_Tip=CC_Tip+Other_Tips;
 


//To Get Actual_Cash_Tip
double Expected_Tip=Expected_Cash_Tip-No_Cash_Tip;
System.out.println("Expected value of Expected Tip is : "+Expected_Tip);

BigDecimal dd=new BigDecimal(Expected_Tip).setScale(2, RoundingMode.CEILING);

Expected_Tip=dd.doubleValue(); 
	//	Expected_Tip=Expected_Tip/Emp_Count;*/

if(Expected_Tip==Actual_ExpectedTip)
{
	test.log(LogStatus.PASS, "Expected Tip Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_Tip-Actual_ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}


//To Get Tip Out Percentage
String Tip_Out_Per=Utility.getReportPropertyUser("Tip_Out_Percentage");
double TipOut_Percentage=Double.parseDouble(Tip_Out_Per);

//To Calculate Tip Out Contribution
double Expected_Tip_Out_Cont=NetSales*TipOut_Percentage/100;

BigDecimal dd3=new BigDecimal(Expected_Tip_Out_Cont).setScale(2, RoundingMode.CEILING);
Expected_Tip_Out_Cont=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_Con = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip Out Contribution is : "+Actual_Tip_Out_Con);	
test.log(LogStatus.INFO, "Total Expected Tip Out Contribution is : "+Actual_Tip_Out_Con);
double Actual_Tip_Out_Cont=Double.parseDouble(Actual_Tip_Out_Con);


//Check whether the Tip Out Contribution is Calculated or not
if(Expected_Tip_Out_Cont==Actual_Tip_Out_Cont)
{
	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
}
else
{
	double TipOut_ContDiff=Expected_Tip_Out_Cont-Actual_Tip_Out_Cont;
	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_Share = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip Out Share is : "+Actual_Tip_Out_Share);	
test.log(LogStatus.INFO, "Total Expected Tip Out Share is : "+Actual_Tip_Out_Share);
double Actual_Tip_Out_Shared=Double.parseDouble(Actual_Tip_Out_Share);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_Cont==Actual_Tip_Out_Shared)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_Shared-Expected_Tip_Out_Cont;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
if(Tip_Shared_Wly==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared is Correct for both In Time to In Hours (Date Range - Weekly)");
}
else
{
	double Tip_Shared_Diff=Tip_Shared_Wly-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared is InCorrect for both In Time to In Hours (Date Range - Weekly). The Values Difference is : "+Tip_Shared_Diff);
}

//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
double Actual_OverAll_Tip=Double.parseDouble(Actual_OverAllTip_Dt);

if(OverAll_Tip_Wly==Actual_OverAll_Tip) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly for In Time to In Hours (Date Range - Weekly)");
}
else
{
	double diff=OverAll_Tip_Wly-Actual_OverAll_Tip;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly for In Time to In Hours (Date Range - Weekly). Diff is : "+diff);
}

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
double Actual_Over_All_Pay=Double.parseDouble(Actual_OverAllPay_Dt);

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Over_All_Pay_Wly==Actual_Over_All_Pay) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly for In Time to In Hours (Date Range - Weekly)");
}
else
{
	double diff=Over_All_Pay_Wly-Actual_Over_All_Pay;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly for In Time to In Hours (Date Range - Weekly). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST Z-A LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.reverse(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for Z-A Last Name");
	}
}
	}
test.log(LogStatus.INFO, "Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range End");
	}
	
	@Test(priority=73,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable(WebDriver driver) throws Exception
	{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	
	
	
	
	
	// Navigate to TipOutTipSharingSettings page 

	driver.switchTo().window(Alltabs.get(3));
	
	
	test.log(LogStatus.INFO, "Disabled All-> Online Pickup Tip, Declared Cash Tip, Gratuity, Driver Compensation) Starts (Daily)");
	
	Thread.sleep(2000);
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();	
	}
	else
	{

	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{

	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();

	}
	else
	{

	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	
	}
	else
	{

	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);
	test.log(LogStatus.PASS, "Publish Your Menu Changes To POS");
	
	
	Thread.sleep(5000);	
	//navigate to roleBasedPayroll page
	driver.switchTo().window(Alltabs.get(2));	
	Thread.sleep(2000);
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);
test.log(LogStatus.INFO, "Disabled All-> Online Pickup Tip, Declared Cash Tip, Gratuity, Driver Compensation) End (Daily)");



	}
	


@Test(priority=74,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisable(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	Thread.sleep(2000);
	
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	test.log(LogStatus.INFO, "Disabled All-> Online Pickup Tip, Declared Cash Tip, Gratuity, Driver Compensation) Starts (Weekly)");
	
	Thread.sleep(5000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	//Select the Process as Daily
	repts.Select_Process("Weekly");

  	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z LastName");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	test.log(LogStatus.INFO, "Disabled All-> Online Pickup Tip, Declared Cash Tip, Gratuity, Driver Compensation) End (Weekly)");

	

	}
	
	
	@Test(priority=73,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_DisableAndEnable_Online_pickup_Tip (WebDriver driver) throws Exception
	{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	
	
	
	
	
	
	test.log(LogStatus.INFO, "Disabled -> Declared Cash Tip, Gratuity, Driver Compensation (Enabled--> Online Pickup Tip) Starts (Daily)");

	//Navigate to TipOutTipSharingSettings page 
	driver.switchTo().window(Alltabs.get(3));
	Thread.sleep(2000);
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{

	}
	else
	{
driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();	
	}
	else
	{

	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();	
	}
	else
	{

	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	}
	else
	{

	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);	
	test.log(LogStatus.PASS, "Publish Your Menu Changes To POS");
	
	
	Thread.sleep(5000);	
	// navigate to payroll report 
	driver.switchTo().window(Alltabs.get(2));
	Thread.sleep(2000);
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);
test.log(LogStatus.INFO, "Disabled -> Declared Cash Tip, Gratuity, Driver Compensation (Enabled--> Online Pickup Tip) End (Daily)");



	}

	@Test(priority=74,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisableAndEnable_Online_pickup_Tip(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	 	

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	





	
test.log(LogStatus.INFO, "Disabled -> Declared Cash Tip, Gratuity, Driver Compensation (Enabled--> Online Pickup Tip) Starts (Weekly)");

Thread.sleep(2000);
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

////To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled -> Declared Cash Tip, Gratuity, Driver Compensation (Enabled--> Online Pickup Tip) End (Weekly)");

	

	}
	

	
	@Test(priority=73,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_DisableAndEnable_declared_cash_tip (WebDriver driver) throws Exception
	{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	
	
	
	
	
	
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Gratuity, Driver Compensation (Enabled--> Declared Cash Tip) Starts (Daily)");

	
	//navigate to TipOutTipSharingSettings
	driver.switchTo().window(Alltabs.get(3));
	Thread.sleep(2000);
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();	
	}
	else
	{

	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{

	}
	else
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
	}
	else
	{

	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();	
	}
	else
	{

	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);	
	test.log(LogStatus.PASS, "Publish Your Menu Changes To POS");
	
	
	Thread.sleep(5000);	
	driver.switchTo().window(Alltabs.get(2));
	Thread.sleep(2000);
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Gratuity, Driver Compensation (Enabled--> Declared Cash Tip) End (Daily)");



	}

	@Test(priority=74,enabled=false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_AllDisableAndEnable_declared_cash_tip(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Gratuity, Driver Compensation (Enabled--> Declared Cash Tip) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Gratuity, Driver Compensation (Enabled--> Declared Cash Tip) End (Weekly)");

	}
	

	
@Test(priority=66,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable_Enable_Gratuity(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	Thread.sleep(2000);
	driver.switchTo().window(Alltabs.get(3));
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Driver Compensation (Enabled--> Gratuity) Starts (Daily)");

	Thread.sleep(2000);
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);	test.log(LogStatus.INFO, "Publish Your Menu Changes To POS");
	
	Thread.sleep(5000);	
	driver.switchTo().window(Alltabs.get(2));
	Thread.sleep(2000);
	
	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Daily");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+Driver_Comp_Dt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(1000);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Driver Compensation (Enabled--> Gratuity) End (Daily)");

	

}

@Test(priority=66,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_All_Disable_Enable_Gratuity(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	
	Thread.sleep(2000);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Driver Compensation (Enabled--> Gratuity) Starts (Weekly)");

	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Weekly");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+Driver_Comp_Dt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(1000);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Driver Compensation (Enabled--> Gratuity) End (Weekly)");

	

}


@Test(priority=77,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_All_Disable_Enable_DrivComp(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	
	Thread.sleep(2000);
	driver.switchTo().window(Alltabs.get(3));
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Gratuity (Enabled--> Driver Compensation) Starts (Daily)");

	
	Thread.sleep(2000);
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);	test.log(LogStatus.INFO, "Publish Your Menu Changes To POS");
	
	driver.switchTo().window(Alltabs.get(2));
	
	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Daily");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

////To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Gratuity (Enabled--> Driver Compensation) End (Daily)");

	Thread.sleep(1000);
	

}

@Test(priority=77,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_All_Disable_Enable_DrivComp(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Gratuity (Enabled--> Driver Compensation) Starts (Weekly)");

	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Weekly");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Declared Cash Tip, Gratuity (Enabled--> Driver Compensation) End (Weekly)");

	Thread.sleep(1000);
	

}


@Test(priority=88,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Gratuity_Disable_Drivercomp_Enable_OLOPickuptip_Enable_Declcashtip(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	Thread.sleep(2000);
	driver.switchTo().window(Alltabs.get(3));
	test.log(LogStatus.INFO, "Disabled -> Gratuity, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) Starts (Daily)");

	Thread.sleep(2000);
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);
	test.log(LogStatus.INFO, "Publish Your Menu Changes To POS");
	
	driver.switchTo().window(Alltabs.get(2));
	
	Thread.sleep(2000);
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Daily");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt+DeclaredCashTipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(1000);
	test.log(LogStatus.INFO, "Disabled -> Gratuity, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) End (Daily)");

	

}

@Test(priority=88,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Gratuity_Disable_Drivercomp_Enable_OLOPickuptip_Enable_Declcashtip(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	test.log(LogStatus.INFO, "Disabled -> Gratuity, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) Starts (Weekly)");

	Thread.sleep(2000);
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Weekly");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

////To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt+DeclaredCashTipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+GratuityDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(1000);
	test.log(LogStatus.INFO, "Disabled -> Gratuity, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) End (Weekly)");

	

}


@Test(priority=99,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_PckUp_Tip_Disable_Drivercomp_Enable_Decl_Cash_Tip_Enable_Gratuity(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	Thread.sleep(2000);
	driver.switchTo().window(Alltabs.get(3));
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) Starts (Daily)");

	Thread.sleep(2000);
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
	
	}
	else
	{
	driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
	}
	
	//Check whether the Online Pickup Tip is Enabled or not
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
	driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
	
	}
	else
	{
	
	}
	
	try
	{
	//Click the Update button
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception k) {}
	Thread.sleep(2000);
	
	//Click Publish button
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	Thread.sleep(5000);
	
	driver.switchTo().window(Alltabs.get(2));
	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Daily");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

////To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	
	Thread.sleep(1000);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) End (Daily)");

	

}
	

@Test(priority=99,enabled=false)
public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_PckUp_Tip_Disable_Drivercomp_Enable_Decl_Cash_Tip_Enable_Gratuity(WebDriver driver) throws Exception
{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	
	
	
	
	
	
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) Starts (Weekly)");

	Thread.sleep(2000);	
	//Create the web element
WebElement html = driver.findElement(By.tagName("html"));
  	//Zoom out the window
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
 
	Thread.sleep(1000);
	//Select the Employee option


repts.Select_Employee("Am Bar Am Bartender");



Thread.sleep(1000);
//Select the Process as Daily
	
	repts.Select_Process("Weekly");   

	
//Select the Date Range


repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));



Thread.sleep(1000);





Thread.sleep(1000);




	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	

	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z FirstName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	

	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));

}
	
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");



List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
Thread.sleep(1000);
//Get Per Rate value
/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
	
//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	

//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
//Get OT Hours
/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
//Get Total Hours
/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();

System.out.println("Total Hours is : "+hours);

test.log(LogStatus.INFO, "Total Hours is : "+hours);*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

Thread.sleep(1000);
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Actual Reg Pay :"+TotalRegPayDt);
double RegPayDt=Double.parseDouble(TotalRegPayDt);


//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);


//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);

//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}



	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
 

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To get Tip Adj from the Report
String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);


//To get Tip Adj from the Report
String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);



//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Dly=Actual_Tip_SharedDt;


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Dly=OverAll_Tip_Dly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Dly=Over_All_Pay_Dly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Dly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
}
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	test.log(LogStatus.INFO, "Disabled -> Online Pickup Tip, Driver Compensation (Enabled--> Online Pickup Tip, Declared Cash Tip) End (Weekly)");

	Thread.sleep(1000);
	

	}

	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Driver_Comp(WebDriver driver) throws Exception
	{
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	driver.switchTo().window(Alltabs.get(3));
	
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip,Driver Compensation Scenario (Enabled ->Online Pckup Tip,Gratuity) Starts (Daily)");
	/*	WebElement labor = driver.findElement(By.xpath("//span[.=' Labor']"));
	
	Actions ac = new Actions(driver);
	Thread.sleep(2000);
	ac.contextClick(labor).build().perform();
	
	Robot rb = new Robot();
	Thread.sleep(2000);
	rb.keyPress(java.awt.event.KeyEvent.VK_DOWN);
	rb.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
	
	rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	
	Thread.sleep(2000);
	
	// It will return the parent window name as a String
	String parent=driver.getWindowHandle();
	
	this.parent_tab=parent;

	Set<String>s11=driver.getWindowHandles();

	// Now iterate using Iterator
	java.util.Iterator<String> I1= s11.iterator();

	while(I1.hasNext())
	{

	String child_window=I1.next();
	
	System.out.println(s11);


	if(!parent.equals(child_window))
	{

this.Child_tab=child_window;

	driver.switchTo().window(child_window);

	System.out.println(driver.switchTo().window(child_window).getTitle());

	
	}

	}
	
	
	Thread.sleep(2000);	
	driver.findElement(By.xpath("(//span[.=''])[3]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[.='Store']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[.=' Report Settings ']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).click();*/
	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is selected");
}
else 
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{

driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{
test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Gratutity check box is selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is disabled");
	}
	else 
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is disabled");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	 
	Thread.sleep(5000);
/*	driver.switchTo().window(parent);
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	*/
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;
	
	driver.switchTo().window(Alltabs.get(2));

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+GratuityDt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip,Driver Compensation Scenario (Enabled ->Online Pckup Tip,Gratuity) End (Daily)");

Thread.sleep(1000);


	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Driver_Comp(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip,Driver Compensation Scenario (Enabled ->Online Pckup Tip,Gratuity) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+GratuityDt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip,Driver Compensation Scenario (Enabled ->Online Pckup Tip,Gratuity) End (Weekly)");


	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Gratuity(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	

	driver.switchTo().window(Alltabs.get(3));

	
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip, Gratuity Scenario (Enabled ->Online Pckup Tip,Driver Compensation) Starts (Daily)");

	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is selected");
}
else 
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{

driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{
test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{
test.log(LogStatus.PASS, "The Gratutity check box is de-selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is enabled already");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is enabled nonw");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt+Driver_Comp_Dt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip, Gratuity Scenario (Enabled ->Online Pckup Tip,Driver Compensation) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip_And_Gratuity(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	






	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip, Gratuity Scenario (Enabled ->Online Pckup Tip,Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+OLO_Pkup_TipDt+Driver_Comp_Dt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip, Gratuity Scenario (Enabled ->Online Pckup Tip,Driver Compensation) End (Weekly)");


	}
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	

	driver.switchTo().window(Alltabs.get(3));

	
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip Scenario (Enabled ->Declared Cash Tip, Gratuity, Driver Compensation) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	test.log(LogStatus.PASS, "The online pick up tip check box is de-selected");
}
else 
{
	test.log(LogStatus.PASS, "The online pick up tip check box is de-selected already");
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{


test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is enabled already");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is enabled nonw");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+GratuityDt+DeclaredCashTipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip Scenario (Enabled ->Declared Cash Tip, Gratuity, Driver Compensation) End (Daily)");


	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip Scenario (Enabled ->Declared Cash Tip, Gratuity, Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+DeclaredCashTipDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip Scenario (Enabled ->Declared Cash Tip, Gratuity, Driver Compensation) End (Weekly)");


	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	

	driver.switchTo().window(Alltabs.get(3));

	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip Scenario (Enabled ->Online Pickup Tip, Gratuity, Driver Compensation) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is de-selected");
}
else 
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	test.log(LogStatus.PASS, "The online pick up tip check box is Enabled");
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{

driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{

test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Gratutity check box is selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is de-selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is enabled already");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is enabled nonw");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+GratuityDt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip Scenario (Enabled ->Online Pickup Tip, Gratuity, Driver Compensation) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Decl_Cash_Tip(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip Scenario (Enabled ->Online Pickup Tip, Gratuity, Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+GratuityDt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+DeclaredCashTipDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled-> Declared Cash Tip Scenario (Enabled ->Online Pickup Tip, Gratuity, Driver Compensation) End (Weekly)");


	}
	

	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Gratuity(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	

	driver.switchTo().window(Alltabs.get(3));

	
	test.log(LogStatus.INFO, "Disabled-> Gratuity Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Driver Compensation) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is selected");
}
else 
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	test.log(LogStatus.PASS, "The online pick up tip check box is diabled");
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{


test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{

test.log(LogStatus.PASS, "The Gratutity check box is selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is enabled already");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is enabled nonw");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+DeclaredCashTipDt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Gratuity Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Driver Compensation) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Gratuity(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Gratuity Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+DeclaredCashTipDt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled-> Gratuity Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Driver Compensation) End (Weekly)");

	}
	
	

	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Driver_Comp(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	

	driver.switchTo().window(Alltabs.get(3));

	
	test.log(LogStatus.INFO, "Disabled-> Driver Compensation Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Gratuity) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is selected");
}
else 
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	test.log(LogStatus.PASS, "The online pick up tip check box is diabled");
	
}
	
	}
	
	
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{


test.log(LogStatus.PASS, "The Declared cash tip check box is disabled");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is de-selected");
	}
	else 
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is enabled");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+OLO_Pkup_TipDt+GratuityDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Driver Compensation Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Gratuity) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Driver_Comp(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	







	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Driver Compensation Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Gratuity) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	
	Thread.sleep(5000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	  
	//Select the Process as Daily
	
	repts.Select_Process("Weekly");

  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	
	Thread.sleep(3000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	Thread.sleep(1000);
	
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Sort_By("A-Z LastName");
	
	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+OLO_Pkup_TipDt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+Driver_Comp_Dt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	
	test.log(LogStatus.INFO, "Disabled-> Driver Compensation Scenario (Enabled ->Online Pickup Tip, Declared Cash Tip, Gratuity) End (Weekly)");


	}
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Gratuity(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	

	driver.switchTo().window(Alltabs.get(3));

	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Gratuity Scenario (Enabled -> Declared Cash Tip, Driver Compensation) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));

if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
{
	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
	test.log(LogStatus.PASS, "The online pick up tip check box is de-selected");
}
else 
{
	
	test.log(LogStatus.PASS, "The online pick up tip check box is selected");
	
}
	
	}
	
	else
	{
	
test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{


test.log(LogStatus.PASS, "The Declared cash tip check box is selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{
driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{

test.log(LogStatus.PASS, "The Gratutity check box is selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

test.log(LogStatus.PASS, "The Driver Compensation check box is de-selected");
	}
	else 
	{
driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
test.log(LogStatus.PASS, "The Driver Compensation check box is enabled");
	}
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
	Thread.sleep(5000);
	driver.switchTo().window(Alltabs.get(2));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	Thread.sleep(8000);
	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	
	
	
	
	
	
	
	
	
	//Create the web element
	WebElement html = driver.findElement(By.tagName("html"));
	  	//Zoom out the window
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	  	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
/*	  	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	
	
	repts.Select_Employee("Am Bar Am Bartender");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily
	
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	
	
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	
	
	Thread.sleep(1000);
	
	
	
	
	
	Thread.sleep(1000);
	
	
	
	
	  
	
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	
	  
	
	
	//Select the Format
	repts.Select_Status("All");
	
	
	
	Thread.sleep(1000);
	//Select the Process as Daily

repts.Select_Sort_By("A-Z FirstName");

	
	
	//Select the Role
	repts.Select_Role("All");
	
	
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+Driver_Comp_Dt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Gratuity Scenario (Enabled -> Declared Cash Tip, Driver Compensation) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Gratuity(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Gratuity Scenario (Enabled -> Declared Cash Tip, Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	Thread.sleep(5000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	//Select the Process as Daily
	repts.Select_Process("Weekly");

  	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z LastName");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(2000);
	//Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+Driver_Comp_Dt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+GratuityDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Gratuity Scenario (Enabled -> Declared Cash Tip, Driver Compensation) End (Weekly)");

	}
	
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Decl_Cash_Tip(WebDriver driver) throws Exception
	{
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	driver.switchTo().window(Alltabs.get(3));

	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Declared Cash Tip Scenario (Enabled -> Gratuity, Driver Compensation) Starts (Daily)");

	
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("//a[.=' Tip Out/Tip Sharing']")).isDisplayed())
	{
		test.log(LogStatus.PASS, "Tip out & tip shared page is shown in the browser");
	
		String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		String s="data:image/png;base64,"+scnShot;
		test.log(LogStatus.INFO,test.addScreenCapture(s));

		if(driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).isSelected())
		{
			//	driver.findElement(By.xpath("//p[contains(.,'Online Pickup Tip')]/../../div[2]/div/input")).click();
			test.log(LogStatus.PASS, "The online pick up tip check box is de-selected");
		}
		else 
		{
	
			test.log(LogStatus.PASS, "The online pick up tip check box is de-selected");
	
		}
	
	}
	
	else
	{
	
		test.log(LogStatus.FAIL, "Tip out & tip shared page is not shown in the browser");
	
	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).isSelected())
	{

		driver.findElement(By.xpath("//p[contains(.,'Declared Cash Tip')]/../../div[2]/div/input")).click();
		test.log(LogStatus.PASS, "The Declared cash tip check box is de-selected");
	}
	else 
	{

		test.log(LogStatus.PASS, "The Declared cash tip check box is enabled");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).isSelected())
	{

		test.log(LogStatus.PASS, "The Gratutity check box is de-selected");
	}
	else 
	{
		driver.findElement(By.xpath("//p[contains(.,'Gratuity')]/../../div[2]/div/input")).click();
		test.log(LogStatus.PASS, "The Gratutity check box is selected");

	}
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).isSelected())
	{

		test.log(LogStatus.PASS, "The Driver Compensation check box is selected");
	}
	else 
	{
		driver.findElement(By.xpath("//p[contains(.,'Driver Compensation')]/../../div[2]/div/input")).click();
		test.log(LogStatus.PASS, "The Driver Compensation check box is enabled");
	}
	try
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
	}
	catch(Exception kj) {}
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='navigation']/ul[2]/li[1]")).click();
	
	
		Thread.sleep(5000);
		driver.switchTo().window(Alltabs.get(2));
	
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	

		Thread.sleep(8000);
		double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z FirstName");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+GratuityDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+DeclaredCashTipDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


Thread.sleep(1000);

test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Declared Cash Tip Scenario (Enabled -> Gratuity, Driver Compensation) End (Daily)");

	}
	
	
	@Test(enabled = false)
	public void Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range_Disable_Online_pckup_Tip_And_Decl_Cash_Tip(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(2000);
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Declared Cash Tip Scenario (Enabled -> Gratuity, Driver Compensation) Starts (Weekly)");

	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	Thread.sleep(5000);
	//Select the Employee option
	repts.Select_Employee("Am Bar Am Bartender");
	
	//Select the Process as Daily
	repts.Select_Process("Weekly");

  	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Sort_By("A-Z LastName");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(2000);
	//Disable the show summary only options
	repts.Disable_Show_Summary_Only();
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Reg Pay')]/div")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OT Pay')]/div")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Pay')]/div")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'CC Tip')][1]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Charge')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Grat')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Emp CC Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Other Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Decl Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Net Sales')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Exp Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Cont')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


////Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Shared')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+Driver_Comp_Dt+GratuityDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt+OLO_Pkup_TipDt+DeclaredCashTipDt;//+Actual_Tip_Out_Adj_Dt;1



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Overall Pay')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	
	
	test.log(LogStatus.INFO, "Disabled-> Online Pickup Tip, Declared Cash Tip Scenario (Enabled -> Gratuity, Driver Compensation) End (Weekly)");


	}
	
	
	


	
	
	

	}