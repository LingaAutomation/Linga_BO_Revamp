package com.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_RevenueCenter_Page 
{
	public WebDriver driver;
	public ExtentTest test;

	public Settings_RevenueCenter_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@mattooltip='Settings']")
	WebElement Settings;

	@FindBy(xpath = "//span[.='Revenue Center']")
	WebElement RevenueCenter;

	@FindBy(xpath = "//button[contains(.,'NEW REVENUE CENTER')]")
	WebElement NewRevenue_Button;

	@FindBy(xpath = "//app-new-revenue-center/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Name;

	@FindBy(xpath = "//app-auto-complete/div/mat-form-field/div/div/div[3]/div/div/input")
	WebElement Node;

	@FindBy(xpath = "//option-panel/div/div/select-option/div/mat-checkbox")
	WebElement Select_All;

	@FindBy(xpath = "//option-panel/div/div/cdk-virtual-scroll-viewport/div/div[1]/select-option/div/mat-checkbox")
	WebElement Node1;

	@FindBy(xpath = "//option-panel/div/div/cdk-virtual-scroll-viewport/div/div[2]/select-option/div/mat-checkbox")
	WebElement Node2;

	@FindBy(xpath = "//option-panel/div/div/cdk-virtual-scroll-viewport/div/div[3]/select-option/div/mat-checkbox")
	WebElement Node3;

	@FindBy(xpath = "//button[.='Save']")
	WebElement save_button;

	@FindBy(xpath = "//button[.='Cancel']")
	WebElement cancle_button;

	@FindBy(xpath = "//span[.='Close ']")
	WebElement Close_button;

	@FindBy(xpath = "//input[@data-placeholder='Search']")
	WebElement search;

	@FindBy(xpath = "//span[.='Revenue ']/../../div[3]/div[2]/button")
	WebElement delete;

	@FindBy(xpath = "//mat-icon[.='keyboard_arrow_right']")
	WebElement Right_Arrow;

	@FindBy(xpath = "//mat-icon[.='keyboard_arrow_left']")
	WebElement Left_Arrow;

	@FindBy(xpath = "//data-grid-row/div/div[3]/div[1]/button")
	WebElement Edit;

	@FindBy(xpath = "//button[.='Update']")
	WebElement update;

	@FindBy(xpath = "//span[.=' Name ']")
	WebElement Name_sort;

	@FindBy(xpath = "//span[.=' Nodes ']")
	WebElement Node_sort;
	
	@FindBy(xpath = "//span[.=' Cancel ']")
	WebElement CancelBtn;


	public void Navigating_Settings()
	{
		Settings.click();
	}

	public void Clicking_RevenueCenter() 
	{
		RevenueCenter.click(); 
	}
	public void Clicking_NewRevenue() 
	{
		NewRevenue_Button.click();
	}
	public void Entering_Name_Node() throws Exception 
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("Revenue");
		Thread.sleep(1000);
		Node.click();
		Thread.sleep(1000);
		Node1.click();
		Thread.sleep(2000);
	}
	public void Entering_Node_Only() throws Exception
	{
		Node.click();
		Thread.sleep(1000);
		Node2.click();
	}
	public void Entering_Name_Only() throws Exception 
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("sa");
	}
	public void Clicking_Canlce() throws Exception 
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("sa");
		Node.click();
		Thread.sleep(1000);
		Select_All.click();
		Thread.sleep(1000);
		//Select_All.click();
	}
	public void Name25_Node() throws Exception
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("1234567890123456789012346");
		Node.click();
		Thread.sleep(1000);
		Select_All.click();
		Thread.sleep(1000); 
	}
	public void Entering_Duplicate() throws Exception 
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("hat34");
		Node.click();
		Thread.sleep(1000);
		Select_All.click();
		Thread.sleep(1000);  
	}
	public void Special_Character() throws Exception
	{
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys("$%^&&*&%#");
		Node.click();
		Thread.sleep(1000);
		Select_All.click();
		Thread.sleep(1000);
	}
	public void Search_Delete() throws Exception 
	{

		search.sendKeys("Re");
		Thread.sleep(1000);
		search.clear();
		search.sendKeys("Revenue");Thread.sleep(1000);
		
		//Get the Revenue Center
		String GetRevenue_First=driver.findElement(By.xpath("//data-grid/div/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText();
	
//		delete.click();
		driver.findElement(By.xpath("//span[.='"+GetRevenue_First+" ']/../../div[3]/div[2]/button")).click();
		Common_XPaths cmp = new Common_XPaths(driver, test);
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		Thread.sleep(2000);
		CancelBtn.click();
		Thread.sleep(1000);
//		delete.click();
		driver.findElement(By.xpath("//span[.='"+GetRevenue_First+" ']/../../div[3]/div[2]/button")).click();

		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		Thread.sleep(2000);
		Utility ut = new Utility();
		cmp.Click_DeleteButton();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Removed Successfully"))
		{
			test.log(LogStatus.PASS, " Revenue Center Deleted successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Revenue center deletion failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	
		search.clear();

	}
	public void Pagination() throws Exception 
	{
		Right_Arrow.click();
		Thread.sleep(1000);
		Right_Arrow.click();
		Thread.sleep(1000);
		Left_Arrow.click();
		Thread.sleep(1000);
		Left_Arrow.click();
	}
	public void search_Edit() throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		
		List<WebElement> col =driver.findElements(By.xpath("//data-grid-row/div/div[3]/div[2]/../../div[1]/span"));
		
		Random r = new Random();
		
		int randomValue =  r.nextInt(col.size());
		
		String ne = col.get(randomValue).getText();
		
		
		search.sendKeys(ne);
		Thread.sleep(1000);
		Edit.click();
		Thread.sleep(1000);
		Name.clear();
		Thread.sleep(1000);
		

		
		Name.sendKeys(ne);
		
		Thread.sleep(1000);
		cmp.Click_CloseButton();
		Thread.sleep(1000);
		Edit.click();
		Thread.sleep(1000);
		Name.clear();
		Thread.sleep(1000);
		Name.sendKeys(ne);
		Thread.sleep(1000);


	}
	public void Sorting_Name() throws Exception 
	{
		Common_XPaths cmp= new Common_XPaths(driver, test);
		Utility ut = new Utility();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		Name_sort.click();
		Name_sort.click();
		Thread.sleep(3000);
		ArrayList<String> ArrLst=new ArrayList<String>();
		List<WebElement> Namelist = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div[1]/div/span"));
		for(WebElement list:Namelist)
		{
			ArrLst.add(list.getText());
			//System.out.println(ArrLst);
		}
		System.out.println(ArrLst);

		ArrayList<String> sortedLst=new ArrayList<String>();

		for(String st:ArrLst)
		{
			sortedLst.add(st);
		}
		//System.out.println(sortedLst);

		if(sortedLst.equals(ArrLst))
		{
			test.log(LogStatus.PASS, "Ascending Order Sorted Correctly");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			System.out.println(sortedLst);
		}


		else
		{
			test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			System.out.println(sortedLst);
		}
	}
	 public void Verify_DescendingNameSorting()
	    {
		    Common_XPaths cmp= new Common_XPaths(driver, test);
			Utility ut = new Utility();
	        Name_sort.click();
	        Name_sort.click();
	        ArrayList<String> ArLst=new ArrayList<String>();
	        
	            List<WebElement> NameLst=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div[1]/div/span"));

	            for(WebElement ele:NameLst)
	            {
	                ArLst.add(ele.getText());
	               
	            }
	            System.out.println(ArLst);

	            ArrayList<String> sortedLst=new ArrayList<String>();

	            for(String st:ArLst)
	            {
	                sortedLst.add(st);
	
	            }

	            Collections.sort(sortedLst);
	            Collections.reverse(sortedLst);
	            System.out.println(sortedLst);

	            if(sortedLst.equals(ArLst))
	            {
	                test.log(LogStatus.PASS, "Desending Order Sorted Correctly");

	                ut.PassedCaptureScreenshotAsBASE64(driver, test);

	                System.out.println(sortedLst);
	            }
	            else
	            {
	                test.log(LogStatus.FAIL, "Desending Order Sorted Incorrect");

	                ut.FailedCaptureScreenshotAsBASE64(driver, test);

	                System.out.println(sortedLst);
	            }
	        }


	public void Clear_search() {
		search.clear();
	}
	public void Sorting_Node() throws Exception 
	{
		Common_XPaths cmp= new Common_XPaths(driver, test);
		Utility ut = new Utility();
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[2]/p"));
		
		for(WebElement Ticket_No_Beforesort : Before_sort)
		{
			ArLst.add(Ticket_No_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		Node_sort.click();
		Thread.sleep(2000);
		Node_sort.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[2]/p"));
		
		for(WebElement Ticket_No_Aftersort:After_Sort) 
		{
			Sorted_List.add(Ticket_No_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
		}
		else 
		{
			test.log(LogStatus.PASS, "Sorting done successfully for Node");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	public void Save() 
	{
		save_button.click();
	}
}
