package com.Pages;

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
	
	@FindBy(xpath = "//app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement Pagination_InputBox;
	
	@FindBy(xpath = "//span[contains(.,'Store Licenses not found')]")
	WebElement LicenseNotFoundMsg;
	
	@FindBy(xpath = "//select-option[1]")
	WebElement Count_10;
	
	@FindBy(xpath = "//select-option[1]")
	WebElement Count_20;
	
	@FindBy(xpath = "//select-option[1]")
	WebElement Count_50;
	
	@FindBy(xpath = "//select-option[1]")
	WebElement Count_100;
	
	public void Verify_Rows_PageCount() throws Exception
	{
		Pagination_InputBox.click();
		
		Count_10.click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 10");
		
		List<WebElement> StoreList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]"));
		
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
		
		List<WebElement> StoreList1=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]"));
		
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
		
		List<WebElement> StoreList2=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]"));
		
		for (WebElement result : StoreList2){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		
		Thread.sleep(1000);
		Pagination_InputBox.click();
		
		Count_100.click();
		test.log(LogStatus.INFO, "Now we click the Pagination option as 100");
		
		List<WebElement> StoreList3=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]"));
		
		for (WebElement result : StoreList3){						
			//Create the web element for delete button
		     List<WebElement> boxes = result.findElements(By.xpath("//button[contains(.,'SIGN OUT')]"));
		     //Create the variable for getting the size of the box
		     int numberOfBoxes = boxes.size();
		     System.out.println("There are totally "+numberOfBoxes+" elements available");
		}
		
		
	}
	
	public void Revert_Licenses() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
//		List<WebElement> StoreList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]/button"));
	
//		for(int i=1;i<=StoreList.size();i++)
//		{
//			driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[7]/button")).click();
//		}
		try
		{
		if(LicenseNotFoundMsg.isDisplayed())
		{
			test.log(LogStatus.INFO, "Store Licenses not found");
		}
		}
		catch(Exception p)
		{
			test.log(LogStatus.PASS, "Store Licenses Available");
			
		List<WebElement> StoreList=driver.findElements(By.xpath("//div[@class='data-grid']/div/div/div/data-grid-row/div/div[1]"));

	for(int i=1;i<=3;i++)
	{
//		for(WebElement ele:StoreList)
//		{
//			String license=ele.getText();
		driver.navigate().refresh();
		Thread.sleep(6000);
		
		Thread.sleep(2000);
		cmp.SearchBox.clear();
		
		String license=driver.findElement(By.xpath("//div[@class='data-grid']/div/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			
			Thread.sleep(2000);
			cmp.SearchBox.clear();
			
			Thread.sleep(2000);
			cmp.SearchBox.sendKeys(license);
			
			Thread.sleep(3000);
			Sign_OutBtn.click();
			
			try
			{
				Thread.sleep(1000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This Node is Configured in 'Revenue Center'. Could not unsync."))
				{
					test.log(LogStatus.INFO, "This Node is Configured in 'Revenue Center'. Could not unsync.");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(2000);
					cmp.SearchBox.clear();
				}
			}
			catch(Exception e)
			{
			
				
				Thread.sleep(1000);
				if(cmp.AlertMessageTitle.getText().equalsIgnoreCase("Do you want to reset the key ? Make sure offline data are posted to server"))
				{
					Thread.sleep(1000);
					cmp.Click_YesButton();
					
					Thread.sleep(3000);
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("License Unlinked from the device Successfully"))
					{
						test.log(LogStatus.PASS, "Licenses Unlinked Successfully");
						
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
//		}
	}
	
	
	
}
