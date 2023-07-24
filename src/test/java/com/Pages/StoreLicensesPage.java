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

public class StoreLicensesPage 
{
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public StoreLicensesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'SIGN OUT')]")
	WebElement Sign_OutBtn;
	
	@FindBy(xpath = "//mat-select/div/div[2]")
	WebElement Pagination_InputBox;
	
	@FindBy(xpath = "//span[contains(.,'Store Licenses not found')]")
	WebElement LicenseNotFoundMsg;
	
	@FindBy(xpath = "//mat-option[2]")
	WebElement Count_10;
	
	@FindBy(xpath = "//mat-option[3]")
	WebElement Count_20;
	
	@FindBy(xpath = "//mat-option[4]")
	WebElement Count_50;
	
	@FindBy(xpath = "//mat-option[5]")
	WebElement Count_100;
	
	public void Verify_Rows_PageCount() throws Exception
	{
		Pagination_InputBox.click();
		
		Count_10.click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
		
		List<WebElement> StoreList=driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		
		for (WebElement result : StoreList){						
		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		
		Thread.sleep(1000);

		Pagination_InputBox.click();
		
		Count_20.click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 20");
		
		List<WebElement> StoreList1=driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		
		for (WebElement result : StoreList1){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		
		Thread.sleep(1000);

		Pagination_InputBox.click();
		
		Count_50.click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 50");
		
		List<WebElement> StoreList2=driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		
		for (WebElement result : StoreList2){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
//		try {
//		Thread.sleep(1000);
//		Pagination_InputBox.click();
//		
//		Count_100.click();
//		test.log(LogStatus.INFO, "Now we click the Pagination option as 100");
//		
//		List<WebElement> StoreList3=driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
//		
//		for (WebElement result : StoreList3){						
//			//Create the web element for delete button
//		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
//		     //Create the variable for getting the size of the box
//		     int numberOfBoxes = boxes.size();
//		     System.out.println("There are totally "+numberOfBoxes+" elements available");
//		}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
	}
	
	@FindBy(xpath =  "//div[@class='alert-header']/div/div/h4")
	WebElement Remainder_Popup;
	
	@FindBy(xpath =  "//button/span[contains(.,'No')]")
	WebElement No_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Close') and contains(@class,'mat-button')]")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//button/span[contains(.,'Yes')]")
	WebElement Yes_btn;
	
	@FindBy(xpath = "//input[contains(@data-placeholder,'Search')]")
	WebElement Search_option;
	
	public void Revert_Licenses1() throws InterruptedException
	{

		List<WebElement> Lst=driver.findElements(By.xpath("(//table/tbody/tr/td[1]/span)[1]"));
		
		//Click the signout button
		for(int i = 1; i <= Lst.size(); i++)
		{
			driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]/div//button")).click();
			
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
				}
				else
				{
					test.log(LogStatus.FAIL, "Remainder popup is displayed successfully, but it have some spelling mistake");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//click the no button
				No_btn.click();
				
				Thread.sleep(2000);

				

			}
		}

		
		List<WebElement> Lsta=driver.findElements(By.xpath("(//table/tbody/tr/td[1]/span)[1]"));
		
		for(int i = 1; i <= Lst.size(); i++)
		{
			driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]/div//button")).click();
			
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
				}
				else
				{
					test.log(LogStatus.FAIL, "Remainder popup is displayed successfully, but it have some spelling mistake");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//click the Close button
				Close_btn.click();
			}
		}
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("(//table/tbody/tr/td[1]/span)[1]")).getText();
		
		//Click the signout button
		for(int i = 1; i <= Lst.size(); i++)
		{
			driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]/div//button")).click();
			
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
				
				Search_option.sendKeys(sa);
				
				Thread.sleep(2000);
				
				List<WebElement> xs = driver.findElements(By.xpath("//span[contains(.,'Store Licenses not found')]"));
				
				if(xs.size() == 1) {
					test.log(LogStatus.PASS, "After revert the license for the partiuclar node, the corresponding node is not available in the store while searching");
				}
				else if(xs.size() == 0)
				{
					test.log(LogStatus.FAIL, "After revert the license for the partiuclar node, the corresponding node is available in the store while searching");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Search_option.clear();
				Thread.sleep(10000);
				break;
			}
		}
	}
	
	
	public void Revert_Licenses()
	{
		cmp=new Common_XPaths(driver, test);
//		List<WebElement> StoreList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]/button"));
	
//		for(int i=1;i<=StoreList.size();i++)
//		{
//			driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]/button")).click();
//		}
		if(LicenseNotFoundMsg.isDisplayed())
		{
			test.log(LogStatus.INFO, "Store Licenses not found");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Licenses Available");
			
		List<WebElement> StoreList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[1]"));

	
		for(WebElement ele:StoreList)
		{
			cmp.SearchBox.clear();
			cmp.SearchBox.sendKeys(ele.getText());
			
			Sign_OutBtn.click();
			
			cmp.Click_YesButton();
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("License Unlinked from the device Successfully"))
			{
				test.log(LogStatus.PASS, "Licenses Unlinked Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This Node is Configured in 'Revenue Center'. Could not unsync."))
			{
				test.log(LogStatus.INFO, "This Node is Configured in 'Revenue Center'. Could not unsync.");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Licenses Unlink Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		}
	}
	
	
	
}
