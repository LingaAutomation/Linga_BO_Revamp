package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Volume;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_InHouseUnits_Page 
{
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	WebDriverWait wait;
	
	public Inventory_InHouseUnits_Page(WebDriver driver,ExtentTest test) 
	{

		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@data-placeholder='Search']")
	WebElement SearchBox;
	
	@FindBy(xpath = "//span[.=' NEW IN HOUSE UNITS ']")
	WebElement InHouseUnit_Button;
	
	@FindBy(xpath = "//app-input[@label='Name']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Name_InputBox;
	
	@FindBy(xpath = "//button[.='Volume']")
	WebElement volume;
	
	@FindBy(xpath = "//button[.='Weight']")
	WebElement Weight;
	
	@FindBy(xpath = "//span[.='Add Conversion Unit']")
	WebElement Conversion_Unit;
	
	@FindBy(xpath = "//b[.=' Rate ']/../../../div[2]/div[1]//input")
	WebElement Rate;
	
	@FindBy(xpath = "//b[.=' Rate ']/../../../div[2]/div[2]//input")
	WebElement Unit_Dropdown;
	
	@FindBy(xpath = "//div[.=' Name ']")
	WebElement Name;
	
	public void Wait_ForElementVisibility(WebElement ele,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void Click_NewInHouseUnit() 
	{
		InHouseUnit_Button.click();
	}
	
	public void Click_Volume() 
	{
		volume.click();
	}
	
	public void Click_Weight() 
	{
		Weight.click();
	}
	
	public void Add_Conversion_Unit() 
	{
		Conversion_Unit.click();
	}
	
	public void Enter_Rate() throws Exception 
	{
		Rate.clear();
		Thread.sleep(500);
		Rate.sendKeys("10");
	}
	
	
	public void Selecting_Unit() throws Exception
	{
		Unit_Dropdown.click();
		Thread.sleep(1000);
//		List<WebElement> UnitList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		
//		int UnitSize=UnitList.size();
//		int randomUnit=ThreadLocalRandom.current().nextInt(2, UnitSize);
//		
//		
//		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomUnit+"]/select-option")).click();
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	}
	
	
	public void Enter_Name(String str) throws Exception 
	{
		Name_InputBox.clear();
		Thread.sleep(500);
		Name_InputBox.sendKeys(str);
		
	}
	
	
	public void Sorting_Name() throws Exception 
	{
		 Common_XPaths cmp=new Common_XPaths(driver, test);
		 Utility ut = new Utility();

//		 for(int i=1;i<=6;i++)
//			{
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//			}
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//tbody[@role='rowgroup']/tr/td[1]"));
		
		for(WebElement Item_Beforesort : Before_sort)
		{
			ArLst.add(Item_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		Name.click();
		Thread.sleep(2000);
		Name.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//tbody[@role='rowgroup']/tr/td[1]"));
		
		for(WebElement Item_Aftersort:After_Sort) 
		{
			Sorted_List.add(Item_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
		}
		else 
		{
			test.log(LogStatus.PASS, "Sorting done successfully for Name");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void SearchAndClickEdit(String SearchValue) throws Exception
	{
		
		Wait_ForElementVisibility(SearchBox, 180);
	
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		try
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div[1]/button")).click();
		
		}
		catch(Exception g)
		{
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div[1]/button")).click();
		}
		
		}
	
	public void SearchAndClickDelete(String SearchValue) throws Exception
	{
		Wait_ForElementVisibility(SearchBox, 180);
		try
		{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div[2]/button")).click();
		Thread.sleep(1000);
		}
		catch(Exception h)
		{
			Thread.sleep(1000);
			SearchBox.clear();
			Thread.sleep(2000);

			SearchBox.sendKeys(SearchValue);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div[2]/button")).click();
			Thread.sleep(1000);
		}
	}
	
	public void SearchAndClickDeleteCancel(String SearchValue) throws Exception
	{
		Wait_ForElementVisibility(SearchBox, 180);
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td[3]//div[1]/button")).click();

	
	}
	
	public void SearchAndClickActivate(String SearchValue) throws Exception
	{
//		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(300));
		Wait_ForElementVisibility(SearchBox, 180);
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(1000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		
		try
		{
		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div/button")).click();
		}
		catch(Exception h)
		{
			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div/button")).click();

		}
	}
	
	@FindBy(xpath = "//button[.=' Cancel ']")
	WebElement Cancel;
	
	public void Cancel() 
	{
		Cancel.click();
	}
	
	@FindBy(xpath = "//button[@routerlink='newInventoryItem']")
	WebElement Inventory_Item;
	
	
}
