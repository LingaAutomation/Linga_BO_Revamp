package com.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Account_License_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_Account_License_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[.='Account Licenses']")
	WebElement AccountLicense_Heading;
	
	@FindBy(xpath = "//span[contains(.,'Node ID')]")
	WebElement NodeID_Col;
	
	@FindBy(xpath = "//span[contains(.,'Store')]")
	WebElement Store_Col;
	
	@FindBy(xpath = "//span[contains(.,'Device Type')]")
	WebElement DeviceType_Col;
	
	@FindBy(xpath = "//span[contains(.,'Device Name')]")
	WebElement DeviceName_Col;
	
	@FindBy(xpath = "//span[contains(.,'Last Login Time')]")
	WebElement LastLoginTime_Col;
	
	@FindBy(xpath = "//span[contains(.,'Last Access Time')]")
	WebElement LastAccessTime_Col;
	
	@FindBy(xpath = "//span[contains(.,'Last Sync Time')]")
	WebElement LastSyncTime_Col;
	
	@FindBy(xpath = "//div/div[8]/div[contains(.,'Actions')]")
	WebElement Actions_Col;

	@FindBy(xpath = "//span[contains(.,'Rows per page')]")
	WebElement RowsPerPage;
	
	@FindBy(xpath = "//button[contains(@class,'mat-button-base active')]")
	WebElement Pagination_Option;
	
	@FindBy(xpath = "//input[contains(@data-placeholder,'Search')]")
	WebElement Search_option;
	
	@FindBy(xpath = "//span[contains(.,'COLUMNS')]")
	WebElement Column_option;
	
	@FindBy(xpath =  "//span[contains(.,'Rows per page:')]/../../div[2]/app-selectbox/div/mat-form-field/div")
	WebElement rowsPerPage_btn;
	
	@FindBy(xpath =  "//select-option[1]/div")
	WebElement fiveRows_Option;
	
	@FindBy(xpath =  "//select-option[2]/div")
	WebElement tenRows_Option;
	
	@FindBy(xpath =  "//select-option[3]/div")
	WebElement fifteenRows_Option;
	
	@FindBy(xpath =  "//select-option[4]/div")
	WebElement twentyRows_Option;
	
	@FindBy(xpath =  "//span[contains(.,'SIGN OUT')]")
	WebElement SignOut_btn;
	
	@FindBy(xpath =  "//div[@class='alert-header']/div/div/h4")
	WebElement Remainder_Popup;
	
	@FindBy(xpath =  "//span[contains(.,'Close') and contains(@class,'mat-button')]")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//button/span[contains(.,'No')]")
	WebElement No_btn;
	
	@FindBy(xpath =  "//button/span[contains(.,'Yes')]")
	WebElement Yes_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Account Licenses')]")
	WebElement AccountLicense_option;
	
	@FindBy(xpath =  "//span[contains(.,'keyboard_backspace')]")
	WebElement Back_btn;
	
	public void resetKey() throws Exception {
		String sas = "";
		
		//Click the Last Access Time
		LastAccessTime_Col.click();
		
		ArrayList<String> ArLst=new ArrayList<String>();
		
		List<WebElement> Lst=driver.findElements(By.xpath("//data-grid-row/div/div[8]/div/button"));
		
		for(WebElement ele:Lst)
		{
			ArLst.add(ele.getText());
		}
		
		ArrayList<String> sortedLst=new ArrayList<String>();
		
		for(String st:ArLst)
		{
			sortedLst.add(st);
		}
		
		Collections.sort(sortedLst);
		//System.out.println(sortedLst);
		
		if(sortedLst.equals(ArLst))
		{
			test.log(LogStatus.PASS, "Ascending Order Sorted Correctly for "+driver.findElement(By.xpath("//data-grid-row/div/div[6]/div/span[@class='header-title']")).getText());
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
			System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
		}
		else
		{
			test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect for "+driver.findElement(By.xpath("//data-grid-row/div/div[6]/div/span[@class='header-title']")).getText());
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
			System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
		}
		
		//Get the value from the table
		//String sa = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();

		
		//Click the signout button
		for(int i = 1; i <= Lst.size(); i++)
		{
			driver.findElement(By.xpath("(//data-grid-row/div/div[8]/div/button)["+i+"]")).click();
			
			Thread.sleep(2000);
			
			try {
				String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
				Thread.sleep(500);
				//Check whether the License unLinked from the device successfully message is displayed
				if(s1.equals("This Node is configured in 'Revenue Center'. could not unsync."))
				{
					test.log(LogStatus.INFO, "This Node is configured in 'Revenue Center'. could not unsync. message is displayed, when user click the Signout button from the list of licenses");		
				}
			
				//Click the close button of warning message
				driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
				
			}
			catch(Exception r){
				if(Remainder_Popup.getText().equals("Remainder"))
				{
					test.log(LogStatus.PASS, "Remainder popup is displayed successfully");
					//sas = driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+"]/data-grid-row/div/div[1]/span")).getText();
				}
				else
				{
					test.log(LogStatus.FAIL, "Remainder popup is displayed successfully, but it have some spelling mistake");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//click the no button
				No_btn.click();
				
				Thread.sleep(2000);			
				ArrayList<String> ArLst1=new ArrayList<String>();
				
				List<WebElement> Lst1=driver.findElements(By.xpath("//data-grid-row/div/div[8]/div/button"));
				
				for(WebElement ele1:Lst1)
				{
					ArLst1.add(ele1.getText());
				}
				
				if(sortedLst.equals(ArLst1))
				{
					test.log(LogStatus.PASS, "Sorted order is not changing when user comeback from alert popup");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					System.out.println("Sorted List from Table(after alert) : "+ArLst1);
					System.out.println("Sorted List from Table(before alert) : "+sortedLst);
				}
				else
				{
					test.log(LogStatus.FAIL, "Sorted order is changing when user comeback from alert popup");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(after alert) : "+ArLst1);
					System.out.println("Sorted List from Table(before alert) : "+sortedLst);
				}
			}
		}
		
		Search_option.clear();
		Thread.sleep(5000);
		
		Search_option.sendKeys(sas);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[contains(.,'SIGN OUT')]")).click();
		
		Thread.sleep(8000);
		
		try {
			String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			Thread.sleep(500);
			//Check whether the License unLinked from the device successfully message is displayed
			if(s1.equals("This Node is configured in 'Revenue Center'. could not unsync."))
			{
				test.log(LogStatus.FAIL, "This Node is configured in 'Revenue Center'. could not unsync. message is displayed, when user click the Signout button from the list of licenses");		
			}
		
			//Click the close button of warning message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			
		}
		catch(Exception r){
			if(Remainder_Popup.getText().equals("Remainder"))
			{
				test.log(LogStatus.PASS, "Remainder popup is displayed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Remainder popup is displayed successfully, but it have some spelling mistake");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			//click the Close button
			Close_btn.click();
		}
		
		//Get the value from the table
		String saq = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();

		driver.findElement(By.xpath("//data-grid-row/div/div/div/button")).click();
		
		Thread.sleep(8000);
		
		try {
			String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			Thread.sleep(500);
			//Check whether the License unLinked from the device successfully message is displayed
			if(s1.equals("This Node is configured in 'Revenue Center'. could not unsync."))
			{
				test.log(LogStatus.INFO, "This Node is configured in 'Revenue Center'. could not unsync. message is displayed, when user click the Signout button from the list of licenses");		
			}
		
			//Click the close button of warning message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			
		}
		catch(Exception r){
			if(Remainder_Popup.getText().equals("Remainder"))
			{
				test.log(LogStatus.PASS, "Remainder popup is displayed successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Remainder popup is displayed successfully, but it have some spelling mistake");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			//click the yes button
			Yes_btn.click();
			
			Thread.sleep(2000);
			
			String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			Thread.sleep(500);
			//Check whether the License unLinked from the device successfully message is displayed
			if(s1.equals("License unLinked from the device successfully"))
			{
				test.log(LogStatus.PASS, "License unLinked from the device successfully message is displayed, when user click the yes button from the alert popup");
			}
			else
			{
				test.log(LogStatus.FAIL, "License unLinked from the device successfully is not displayed, when user click the yes button from the alert popup");
			}
			
			//Click the close button of warning message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			
			Search_option.sendKeys(saq);
			
			Thread.sleep(2000);
			
			List<WebElement> xs = driver.findElements(By.xpath("//span[contains(.,'Account Licenses not found')]"));
			
			if(xs.size() == 1) {
				test.log(LogStatus.PASS, "After revert the license for the partiuclar node, the corresponding node is not available in the store while searching");
			}
			else if(xs.size() == 0)
			{
				test.log(LogStatus.FAIL, "After revert the license for the partiuclar node, the corresponding node is available in the store while searching");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Search_option.clear();
		}

		
		/*
		 * //Click the Last Login Time LastLoginTime_Col.click();
		 * 
		 * ArrayList<String> ArLsta=new ArrayList<String>();
		 * 
		 * List<WebElement> Lsta=driver.findElements(By.xpath(
		 * "//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[5]"));
		 * 
		 * for(WebElement elea:Lsta) { ArLsta.add(elea.getText()); }
		 * 
		 * ArrayList<String> sortedLsta=new ArrayList<String>();
		 * 
		 * for(String sta:ArLsta) { sortedLsta.add(sta); }
		 * 
		 * Collections.sort(sortedLsta); //System.out.println(sortedLst);
		 * 
		 * if(sortedLsta.equals(ArLsta)) { test.log(LogStatus.PASS,
		 * "Ascending Order Sorted Correctly for "+driver.findElement(By.xpath(
		 * "//data-grid-row/div/div[5]/div/span[@class='header-title']")).getText());
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test);
		 * System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLsta);
		 * System.out.println("Sorted List from Table(Expected - Ascending) : "
		 * +sortedLsta); } else { test.log(LogStatus.FAIL,
		 * "Ascending Order Sorted Incorrect for "+driver.findElement(By.xpath(
		 * "//data-grid-row/div/div[5]/div/span[@class='header-title']")).getText());
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test);
		 * 
		 * System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLsta);
		 * System.out.println("Sorted List from Table(Expected - Ascending) : "
		 * +sortedLsta); }
		 * 
		 * //Get the value from the table //String sa = driver.findElement(By.xpath(
		 * "//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();
		 * 
		 * //Click the signout button for(int i = 1; i <= Lst.size(); i++) {
		 * driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+
		 * "]/data-grid-row/div/div[8]/div/button")).click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * try { String s1 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * Thread.sleep(500); //Check whether the License unLinked from the device
		 * successfully message is displayed
		 * if(s1.equals("This Node is configured in 'Revenue Center'. could not unsync."
		 * )) { test.log(LogStatus.INFO,
		 * "This Node is configured in 'Revenue Center'. could not unsync. message is displayed, when user click the Signout button from the list of licenses"
		 * ); }
		 * 
		 * //Click the close button of warning message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 * 
		 * } catch(Exception r){ if(Remainder_Popup.getText().equals("Remainder")) {
		 * test.log(LogStatus.PASS, "Remainder popup is displayed successfully"); } else
		 * { test.log(LogStatus.FAIL,
		 * "Remainder popup is displayed successfully, but it have some spelling mistake"
		 * ); ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 * 
		 * //click the Close button Close_btn.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * ArrayList<String> ArLsta1=new ArrayList<String>();
		 * 
		 * List<WebElement> Lsta1=driver.findElements(By.xpath(
		 * "//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[5]"));
		 * 
		 * for(WebElement elea1:Lsta1) { ArLsta1.add(elea1.getText()); }
		 * 
		 * if(sortedLsta.equals(ArLsta1)) { test.log(LogStatus.PASS,
		 * "Sorted order is not changing when user comeback from alert popup");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test);
		 * System.out.println("Sorted List from Table(after alert) : "+ArLsta1);
		 * System.out.println("Sorted List from Table(before alert) : "+sortedLsta); }
		 * else { test.log(LogStatus.FAIL,
		 * "Sorted order is changing when user comeback from alert popup");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test);
		 * 
		 * System.out.println("Sorted List from Table(after alert) : "+ArLsta1);
		 * System.out.println("Sorted List from Table(before alert) : "+sortedLsta); } }
		 * }
		 * 
		 * 
		 * 
		 * 
		 * //Click the Last Sync Time LastSyncTime_Col.click();
		 * 
		 * ArrayList<String> ArLstb=new ArrayList<String>();
		 * 
		 * List<WebElement> Lstb=driver.findElements(By.xpath(
		 * "//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[7]"));
		 * 
		 * for(WebElement eleb:Lstb) { ArLstb.add(eleb.getText()); }
		 * 
		 * ArrayList<String> sortedLstb=new ArrayList<String>();
		 * 
		 * for(String stb:ArLstb) { sortedLstb.add(stb); }
		 * 
		 * Collections.sort(sortedLstb); //System.out.println(sortedLst);
		 * 
		 * if(sortedLstb.equals(ArLstb)) { test.log(LogStatus.PASS,
		 * "Ascending Order Sorted Correctly for "+driver.findElement(By.xpath(
		 * "//data-grid-row/div/div[7]/div/span[@class='header-title']")).getText());
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test);
		 * System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLstb);
		 * System.out.println("Sorted List from Table(Expected - Ascending) : "
		 * +sortedLstb); } else { test.log(LogStatus.FAIL,
		 * "Ascending Order Sorted Incorrect for "+driver.findElement(By.xpath(
		 * "//data-grid-row/div/div[7]/div/span[@class='header-title']")).getText());
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test);
		 * 
		 * System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLstb);
		 * System.out.println("Sorted List from Table(Expected - Ascending) : "
		 * +sortedLstb); }
		 * 
		 * //Get the value from the table String sa = driver.findElement(By.xpath(
		 * "//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();
		 * 
		 * //Click the signout button for(int i = 1; i <= Lst.size(); i++) {
		 * driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+
		 * "]/data-grid-row/div/div[8]/div/button")).click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * try { String s1 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * Thread.sleep(500); //Check whether the License unLinked from the device
		 * successfully message is displayed
		 * if(s1.equals("This Node is configured in 'Revenue Center'. could not unsync."
		 * )) { test.log(LogStatus.INFO,
		 * "This Node is configured in 'Revenue Center'. could not unsync. message is displayed, when user click the Signout button from the list of licenses"
		 * ); }
		 * 
		 * //Click the close button of warning message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 * 
		 * } catch(Exception r){ if(Remainder_Popup.getText().equals("Remainder")) {
		 * test.log(LogStatus.PASS, "Remainder popup is displayed successfully"); } else
		 * { test.log(LogStatus.FAIL,
		 * "Remainder popup is displayed successfully, but it have some spelling mistake"
		 * ); ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 * 
		 * //click the yes button Yes_btn.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * String s1 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * Thread.sleep(500); //Check whether the License unLinked from the device
		 * successfully message is displayed
		 * if(s1.equals("License unLinked from the device successfully")) {
		 * test.log(LogStatus.PASS,
		 * "License unLinked from the device successfully message is displayed, when user click the yes button from the alert popup"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "License unLinked from the device successfully is not displayed, when user click the yes button from the alert popup"
		 * ); }
		 * 
		 * //Click the close button of warning message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 * 
		 * Search_option.sendKeys(sa);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * List<WebElement> xs = driver.findElements(By.
		 * xpath("//span[contains(.,'Account Licenses not found')]"));
		 * 
		 * if(xs.size() == 1) { test.log(LogStatus.PASS,
		 * "After revert the license for the partiuclar node, the corresponding node is not available in the store while searching"
		 * ); } else if(xs.size() == 0) { test.log(LogStatus.FAIL,
		 * "After revert the license for the partiuclar node, the corresponding node is available in the store while searching"
		 * );
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 * 
		 * Search_option.clear(); } }
		 */		

		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		AccountLicense_option.click();
		
		Thread.sleep(10000);
	}
	
	public void verifyAccountLicenseElements() throws InterruptedException {
		Thread.sleep(5000);
		if(AccountLicense_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Account License heading is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Account License heading is not displayed in account license page");
		}
		
		if(NodeID_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Node Id column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Node Id column is not displayed in account license page");
		}
		
		if(Store_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Store column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Store column is not displayed in account license page");
		}
		
		if(DeviceType_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Device Type column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Device Type column is not displayed in account license page");
		}
		
		if(DeviceName_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Device Name column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Device Name column is not displayed in account license page");
		}
		
		if(LastLoginTime_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Last Login Time column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Last Login Time column is not displayed in account license page");
		}
		
		if(LastAccessTime_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Last Access Time column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Last Access Time column is not displayed in account license page");
		}
		
		if(LastSyncTime_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Last Sync Time column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Last Sync Time column is not displayed in account license page");
		}
		
		if(Actions_Col.isDisplayed()) {
			test.log(LogStatus.PASS, "Actions column is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Actions column is not displayed in account license page");
		}
		
		try {
			if(RowsPerPage.isDisplayed()) {
				test.log(LogStatus.PASS, "Rows Per Page is displayed in account license page");
				
				paginationValidation();
			}
		}
		catch(Exception r) {
			test.log(LogStatus.FAIL, "Rows Per Page is not displayed in account license page");
		}
		
		if(Pagination_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Pagination Option is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Pagination Option is not displayed in account license page");
		}
		
		if(Search_option.isDisplayed()) {
			test.log(LogStatus.PASS, "Search option is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Search option is not displayed in account license page");
		}
		
		if(Column_option.isDisplayed()) {
			test.log(LogStatus.PASS, "Column option is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Column option is not displayed in account license page");
		}

	}
	
	public void paginationValidation() throws Exception {
		
		//get the total number of pages
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto ng-star-inserted']/button"));
				
		if(s.size() == 1)
		{
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
		}
		else if(s.size() == 2) {
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
		}
		else if(s.size() == 3) {
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//Rows count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "15 rows are displayed when user select the 15 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "15 rows are not displayed when user select the 15 rows per page option");
			}
		}	
		else{
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//Rows count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "15 rows are displayed when user select the 15 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "15 rows are not displayed when user select the 15 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 20 from the option
			twentyRows_Option.click();
			
			//Rows count
			List<WebElement> d3 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d3.size() <= 20 && d3.size() > 15) {
				test.log(LogStatus.PASS, "20 rows are displayed when user select the 20 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "20 rows are not displayed when user select the 20 rows per page option");
			}
		}	
		
		
	}

	public void Ascending_And_Descending_Order() {
		List<WebElement> col = driver.findElements(By.xpath("//data-grid-row/div/div/div/span[@class='header-title']"));
		
		for(int i = 1; i <= col.size(); i++) {
			
			
			//double click the required row for descending order
			driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			
			ArrayList<String> ArLst=new ArrayList<String>();
			
			if(driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/div[contains(@class,'mode-asc')]")).isDisplayed())
			{
				List<WebElement> Lst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div["+i+"]"));
				
				for(WebElement ele:Lst)
				{
					ArLst.add(ele.getText());
				}
				
				ArrayList<String> sortedLst=new ArrayList<String>();
				
				for(String st:ArLst)
				{
					sortedLst.add(st);
				}
				
				Collections.sort(sortedLst);
				//System.out.println(sortedLst);
				
				if(sortedLst.equals(ArLst))
				{
					test.log(LogStatus.PASS, "Ascending Order Sorted Correctly for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
				}
				else
				{
					test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
				}
			}
		}
		
		for(int i = 1; i <= col.size(); i++) {
			
			
			//click the required row for descending order
			driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			//driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			
			ArrayList<String> ArLst=new ArrayList<String>();
			
			if(driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/div[contains(@class,'mode-desc')]")).isDisplayed())
			{
				List<WebElement> Lst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div["+i+"]"));
				
				for(WebElement ele:Lst)
				{
					ArLst.add(ele.getText());
				}
				
				ArrayList<String> sortedLst=new ArrayList<String>();
				
				for(String st:ArLst)
				{
					sortedLst.add(st);
				}
				
				Collections.sort(sortedLst);
				Collections.reverse(sortedLst);
				//System.out.println(sortedLst);
				
				if(sortedLst.equals(ArLst))
				{
					test.log(LogStatus.PASS, "Desending Order Sorted Correctly for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Descending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Descending) : "+sortedLst);
				}
				else
				{
					test.log(LogStatus.FAIL, "Desending Order Sorted Incorrect for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Descending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Descending) : "+sortedLst);
				}
			}
		}
	}
	
	
	public void Filter_Columns() throws Exception
	{
		Thread.sleep(3000);
		Column_option.click();
		
		//Deselect Select All
		driver.findElement(By.xpath("//select-option[@class]")).click();
		Thread.sleep(500);
		
		Thread.sleep(1000);
		List<WebElement> FilterList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option"));
				
		for(int i = 2; i <= FilterList.size(); i++)
		{
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div["+i+"]/select-option")).click();
			
			if(driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText().equalsIgnoreCase(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div["+i+"]/select-option")).getText()))
				
			{
				test.log(LogStatus.PASS, driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div["+i+"]/select-option")).getText()+ " Filtered Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div["+i+"]/select-option")).getText()+ " Filter Unsuccessful. Wrongly filtered as "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText());
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div["+i+"]/select-option")).click();
		}
		
		driver.findElement(By.xpath("//select-option[@class]")).click();

	}
	
	public void search() throws InterruptedException {
		
		Search_option.clear();
		Thread.sleep(15000);
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();
		
		List<WebElement> qw = driver.findElements(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div/span"));
	
		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		List<WebElement> qw1 = driver.findElements(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div/span"));
		
		//Get the value from the table
		String sa1 = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();

		if(sa.equals(sa1))
		{
			test.log(LogStatus.PASS, "The searched result was displayed successfully for the respective keyword");
			if(qw.size() == qw1.size()) {
				test.log(LogStatus.PASS, "All the required field values are displayed after searching");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "All the required field values are not displayed after searching");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else {
			test.log(LogStatus.PASS, "The searched result was not displayed successfully for the respective keyword");
		}
		
		Search_option.clear();
		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		AccountLicense_option.click();
		
		Thread.sleep(10000);
	}

}
