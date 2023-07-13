package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_Adjust_Inventory_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;

	Utility ut = new Utility();

	String brInventoryCount = ""; double brInvenCunt;
	
	String invenItem = "";
	
	double cunt , cuntq;
	
	
	
	
	
	

	String CostPerUnit = ""; double CPU;

	String ValueOnHand = ""; double VOH;

	String invenPurItem = "";

	String quantityItem = ""; double QI;

	String quantityPurItem = ""; double QPI;

	String vendora = "";
	
	int receiveQty = 7;

	public Inventory_Adjust_Inventory_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(.,'BULK ADJUSTMENT')]")
	WebElement BulkAdjustment;

	@FindBy(xpath = "//button[contains(@class,'page-button')]")
	WebElement PageBtn;
	
	@FindBy(xpath = "//button[contains(.,'INVENTORY ITEM') and contains(@class,'active')]")
	WebElement InventoryItemBtnActive;

	@FindBy(xpath = "//button[contains(.,'RETAIL ITEM') and contains(@class,'active')]")
	WebElement RetailItemBtnActive;

	@FindBy(xpath = "//button[contains(.,'SUB-RECIPE') and contains(@class,'active')]")
	WebElement SubRecipeBtnActive;
	
	@FindBy(xpath = "//button[contains(.,'INVENTORY ITEM')]")
	WebElement InventoryItemBtn;

	@FindBy(xpath = "//button[contains(.,'RETAIL ITEM')]")
	WebElement RetailItemBtn;

	@FindBy(xpath = "//button[contains(.,'SUB-RECIPE')]")
	WebElement SubRecipeBtn;
	
	@FindBy(xpath = "//button[contains(.,'Download Template')]")
	WebElement DownloadTemplate;
	
	@FindBy(xpath = "//button[contains(.,'Upload Inventory Count')]")
	WebElement UploadInventoryCount;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchInput;
	
	@FindBy(xpath = "//button[contains(.,'COLUMNS')]")
	WebElement Column;
	
	@FindBy(xpath = "//data-grid-row/div/div[contains(.,'Name')]")
	WebElement Name_Column;
	
	@FindBy(xpath = "//data-grid-row/div/div[contains(.,'Type')]")
	WebElement Type_Column;
	
	@FindBy(xpath = "//data-grid-row/div/div[contains(.,'Inventory Count')]")
	WebElement Inventory_Count_Column;
	
	@FindBy(xpath = "//div[contains(.,'Actions') and contains(@class,'data-grid-header ')]")
	WebElement Actions_Column;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search;

	@FindBy(xpath = "//button[contains(.,'COLUMNS')]")
	WebElement Columns;

	public void Verify_Adjust_Inventory_Page() {
		try {
			if (BulkAdjustment.isDisplayed()) {
				test.log(LogStatus.PASS, "Bulk Adjustment button is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Bulk Adjustment button is not displayed");
		}

		try {
			if (InventoryItemBtnActive.isDisplayed()) {
				test.log(LogStatus.PASS, "Inventory Item tab is displayed and which is activated");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Inventory Item tab is not displayed");
		}

		try {
			if (RetailItemBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "Retail Item Tab is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Retail Item Tab is not displayed");
		}

		try {
			if (SubRecipeBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "Sub Recipe Tab is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Sub Recipe Tab is not displayed");
		}
		
		try {
			if (Search.isDisplayed()) {
				test.log(LogStatus.PASS, "Search field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Search field is not displayed");
		}

		try {
			if (Columns.isDisplayed()) {
				test.log(LogStatus.PASS, "Columns field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Columns field is not displayed");
		}

		try {
			if (DownloadTemplate.isDisplayed()) {
				test.log(LogStatus.PASS, "Download Tepmlate button is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Download Tepmlate button is not displayed");
		}
		
		try {
			if (UploadInventoryCount.isDisplayed()) {
				test.log(LogStatus.PASS, "Upload Inventory Count button is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Upload Inventory Count button is not displayed");
		}

		try {
			if (Name_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Name Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Name Column is not displayed");
		}

		try {
			if (Type_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Type Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Type Column is not displayed");
		}

		try {
			if (Inventory_Count_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Inventory Count Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Inventory Count Column is not displayed");
		}

		try {
			if (Actions_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Actions Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Actions Column is not displayed");
		}
	}

	public void SelectPage_And_SelectActions() throws Exception {
		
		//get the list of page buttons in the current page
		List<WebElement> page = driver.findElements(By.xpath("//button[contains(@class,'page-button')]"));
				
		if(page.size() == 1) {}
		else {
			// create the random variable
			int rand = ThreadLocalRandom.current().nextInt(1, page.size());
			
			//Click the random page from the list of pages
			driver.findElement(By.xpath("(//button[contains(@class,'page-button')])["+rand+"]")).click();
			
			Thread.sleep(3000);
		}
		
		//get the list of actions button in the current page
		List<WebElement> act = driver.findElements(By.xpath("//button[contains(@class,'action-button')]"));
		
		if(act.size()==1) {
		
			//get the inventory item name
			invenItem = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[1]/span")).getText();
			
			//get the quantity from the table
			brInventoryCount = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[3]/span")).getText();
			
			//driver.findElement(By.xpath("//button[contains(@class,'action-button')]")).click();
			
		}else {
			//create the random variable
			int rand = ThreadLocalRandom.current().nextInt(1, act.size());
			
			//get the inventory item name
			invenItem = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div["+rand+"]/div/data-grid-row/div/div[1]/span")).getText();
			
			//get the quantity from the table
			brInventoryCount = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div["+rand+"]/div/data-grid-row/div/div[3]/span")).getText();
			
			//Click the random actions button
			//driver.findElement(By.xpath("(//button[contains(@class,'action-button')])["+rand+"]")).click();

		}
	}
	
	@FindBy(xpath = "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	public void verify_The_Inventory_Item() throws Exception {
		
		//navigate to the Inventory item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryItem");
	
		Thread.sleep(5000);

		// Clear the search field
		Search.clear();

		// enter the inventory item
		Search.sendKeys(invenItem);
		Thread.sleep(4500);
		
		try {
			//|| driver.findElement(By.xpath("//span[contains(.,'Item not found')]")).isDisplayed()
			// get the success message
			if (successMessage.getText().equals("Internal Server Error") ) {
				test.log(LogStatus.FAIL, "The required item is not loaded in the inventory item page");
			}
		}catch(Exception sd) {
			//verify the required item is displayed or not
			if (driver.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[1]/span")).getText().trim().equalsIgnoreCase(invenItem)) {
				
				//get the quantity from the inventory item page
				quantityItem = driver.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[8]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				//print the quantity
				System.out.println("QTY is : "+quantityItem);
				
				//convert in to double value
				QI = Double.parseDouble(quantityItem);
				
				//get the cost per unit value
				CostPerUnit = driver.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				//print the cost per unit value
				System.out.println("cost per unit is : "+CostPerUnit);
				
				//convert into double
				CPU = Double.parseDouble(CostPerUnit);

				//get the value of value on hand field
				ValueOnHand = driver.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				
				//print the value on hand value
				System.out.println("value on hand is : "+ValueOnHand);
				
				//convert the value on hand value in to double value
				VOH = Double.parseDouble(ValueOnHand);
			}
		}
		
		//navigate to the Adjust Inventory page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "adjustInventory");
		
		Thread.sleep(4000);
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Reason Type')]/../../input")
	WebElement ReasonType;
	
	@FindBy(xpath = "//div[@class='option-list']//input[@data-placeholder='Search']")
	WebElement SearchBox_DropDown;
	
	@FindBy(xpath = "//button/span/mat-icon[.='arrow_drop_up']")
	WebElement arrowDrop_Up;
	
	@FindBy(xpath = "//button/span/mat-icon[.='arrow_drop_down']")
	WebElement arrowDrop_Down;
	
	@FindBy(xpath = "//div[contains(.,'Count Must be greater than Existing Inventory Count') and contains(@class,'color-red')]")
	WebElement ErrorMsg_Increase;
	
	@FindBy(xpath = "//div[contains(.,'Count Must be less than Existing Inventory Count') and contains(@class,'color-red')]")
	WebElement ErrorMsg_Decrease;
	
	@FindBy(xpath = "//button[contains(.,'Update')]")
	WebElement Update;
	
	
	

	
	public void increase_Inventory_Item() throws Exception {
		SelectPage_And_SelectActions();
		
		verify_The_Inventory_Item();
		
		// Clear the search field
		Search.clear();

		// enter the inventory item
		Search.sendKeys(invenItem);
		Thread.sleep(4500);
		
		//get the quantity from the table
		String itemCnt = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[3]/span")).getText().replace(",", "");

		//print the quantity value
		System.out.println("Item Count is : "+itemCnt);
		
		//convert the value
		cunt = Double.parseDouble(itemCnt);
		
		//Click the action button
		driver.findElement(By.xpath("//button[contains(@class,'action-button')]")).click();
		
		//get the quantity from the Adjust Inventory Popup screen
		String cnt = driver.findElement(By.xpath("//input[@min='0' and @type='number']")).getAttribute("value");
		
		//print the value of quantity count           
		System.out.println("Item count in the adjust inventory screen : "+cnt);
		
		//convert the value
		double cunt1 = Double.parseDouble(cnt);
		
		if(cunt == cunt1) {
			test.log(LogStatus.PASS, "The required quantity is displayed in the Adjust inventory screen");
		}else {
			double diff = cunt - cunt1;
			test.log(LogStatus.FAIL, "The quantity is difference between the dashboard and adjust inventory screen. And the difference is : "+ diff);
		}
		
		//CLick the reason type
		ReasonType.click();
		
		//search for increase
		SearchBox_DropDown.sendKeys("Increase");
		
		// Click the first option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		//Increase the count
		for(int i = 1; i <= 13;i++) {
			//Click the increase button
			arrowDrop_Up.click();
		}
		
		cunt = cunt + 13;
		
		//decrease the count
		for(int i = 15; i <= 1;i--) {
			//Click the decrease button
			arrowDrop_Down.click();
			
			if(i >= 14 && ErrorMsg_Increase.isDisplayed()) {
				test.log(LogStatus.PASS, "Error messase is displayed, when user decrese the item count below the Level already we have");
			}
			else {
				test.log(LogStatus.FAIL, "Error message is not displayed, when user decrease the item count below the level already we have");
			}
		}
		
		//click the update button
		Update.click();
		
		try {
			if(ReasonType.isDisplayed()) {
				test.log(LogStatus.INFO, "Inventory Count is not getting updated which is still available in the Edit - Adjust inventory page");
			}
			
			//Increase the count
			for(int i = 1; i <= 7;i++) {
				//Click the increase button
				arrowDrop_Up.click();
			}
			
			cunt = cunt - 15 + 7;
			
			//click the update button
			Update.click();
			
			Thread.sleep(1500);
			// get the success message
			if (successMessage.getText().equals("Stock adjusted successfully") ) {
				test.log(LogStatus.PASS, "Stock adjusted successfully message is displayed when user click the update button of Adjust Inventory");
			}else {
				test.log(LogStatus.FAIL, "Stock adjusted successfully message is not displayed when user click the update button of Adjust Inventory");
			}
			
			
		}catch(Exception s) {
			if(BulkAdjustment.isDisplayed()) {
				test.log(LogStatus.FAIL, "Inventory Count is getting updated or Adjust inventory page is getting closed");
			}
			
			// Clear the search field
			Search.clear();

			// enter the inventory item
			Search.sendKeys(invenItem);
			Thread.sleep(4500);
			
			//get the quantity from the table
			String itemCntq = driver.findElement(By.xpath("//div[contains(@class,'grid-rows')]/div[1]/div/data-grid-row/div/div[3]/span")).getText().replace(",", "");

			//print the quantity value
			System.out.println("Item Count is : "+itemCntq);
			
			//convert the value
			cuntq = Double.parseDouble(itemCntq);
			
			//Click the action button
			driver.findElement(By.xpath("//button[contains(@class,'action-button')]")).click();
			
			//get the quantity from the Adjust Inventory Popup screen
			String cntq = driver.findElement(By.xpath("//input[@min='0' and @type='number']")).getAttribute("value");
			
			//print the value of quantity count           
			System.out.println("Item count in the adjust inventory screen : "+cntq);
			
			//convert the value
			double cunt1q = Double.parseDouble(cntq);
			
			if(cuntq == cunt1q) {
				test.log(LogStatus.PASS, "The required quantity is displayed in the Adjust inventory screen");
			}else {
				double diff = cuntq - cunt1q;
				test.log(LogStatus.FAIL, "The quantity is difference between the dashboard and adjust inventory screen. And the difference is : "+ diff);
			}
			
			//CLick the reason type
			ReasonType.click();
			
			//search for increase
			SearchBox_DropDown.sendKeys("Increase");
			
			// Click the first option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			
			//Increase the count
			for(int i = 1; i <= 13;i++) {
				//Click the increase button
				arrowDrop_Up.click();
			}
			
			cuntq = cuntq +13;
			
			//decrease the count
			for(int i = 15; i <= 1;i--) {
				//Click the decrease button
				arrowDrop_Down.click();
				
				if(i >= 14 && ErrorMsg_Increase.isDisplayed()) {
					test.log(LogStatus.PASS, "Error messase is displayed, when user decrese the item count below the Level already we have");
				}
				else {
					test.log(LogStatus.FAIL, "Error message is not displayed, when user decrease the item count below the level already we have");
				}
			}
			
			//Increase the count
			for(int i = 1; i <= 7;i++) {
				//Click the increase button
				arrowDrop_Up.click();
			}
			
			cuntq = cuntq - 15 + 7;
			
			//click the update button
			Update.click();
			
			Thread.sleep(1500);
			// get the success message
			if (successMessage.getText().equals("Stock adjusted successfully") ) {
				test.log(LogStatus.PASS, "Stock adjusted successfully message is displayed when user click the update button of Adjust Inventory");
			}else {
				test.log(LogStatus.FAIL, "Stock adjusted successfully message is not displayed when user click the update button of Adjust Inventory");
			}
			
		}
	
	}
	
	public void Verify_The_Inventory_ItemPage() {
		
	}
}