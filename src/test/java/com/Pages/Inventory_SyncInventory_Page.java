package com.Pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_SyncInventory_Page extends BasePage
{
	SelfHealingDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;
	
	String recipeUnit, recipePrice;
	
	Utility ut=new Utility();
	
	public Inventory_SyncInventory_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//h3[contains(.,'Inventory Management')]")
	WebElement InventoryManagementTitle;
	
	@FindBy(xpath =  "//div[contains(.,'Create purchase orders') and contains(@class,'grid-element text')]")
	WebElement CreatePurchaseOrder;
	
	@FindBy(xpath =  "//div[contains(.,'Receive low stock email alerts') and contains(@class,'grid-element text')]")
	WebElement ReceiveLowStock;
	
	@FindBy(xpath =  "//div[contains(.,'Calculate your cogs') and contains(@class,'grid-element text')]")
	WebElement CalculateYourCoges;
	
	@FindBy(xpath =  "//div[contains(.,'Create recipes for your menu items') and contains(@class,'grid-element text')]")
	WebElement CreateRecForYourMeumItem;
	
	@FindBy(xpath =  "//div[contains(.,'Theoretical vs actual inventory') and contains(@class,'grid-element text')]")
	WebElement Theoretical;
	
	@FindBy(xpath =  "//div[contains(.,'Track wastage, theft and spoilage') and contains(@class,'grid-element text')]")
	WebElement TrackWastage;
	
	@FindBy(xpath =  "//div[contains(.,'Know your food cost') and contains(@class,'grid-element text')]")
	WebElement KnowYourFoodCost;
	
	@FindBy(xpath =  "//button[contains(.,'SYNC DATA TO INVENTORY')]")
	WebElement SyncBtn;
	
	@FindBy(xpath =  "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	
		
	
	public void Verify_PurchaseTemplate_Page() {
		try {
			if(InventoryManagementTitle.isDisplayed()) {
				test.log(LogStatus.PASS, "Inventory Management is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Inventory Management is not displayed in the Sync Inventory page");}
		
		try {
			if(CreatePurchaseOrder.isDisplayed()) {
				test.log(LogStatus.PASS, "Create purchase orders is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Create purchase orders is not displayed in the Sync Inventory page");}

		try {
			if(ReceiveLowStock.isDisplayed()) {
				test.log(LogStatus.PASS, "Receive low stock email alerts is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Receive low stock email alerts is not displayed in the Sync Inventory page");}
		
		try {
			if(CalculateYourCoges.isDisplayed()) {
				test.log(LogStatus.PASS, "Calculate your cogs is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Calculate your cogs is not displayed in the Sync Inventory page");}

		try {
			if(CreateRecForYourMeumItem.isDisplayed()) {
				test.log(LogStatus.PASS, "Create recipes for your menu items is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Create recipes for your menu items is not displayed in the Sync Inventory page");}

		try {
			if(Theoretical.isDisplayed()) {
				test.log(LogStatus.PASS, "Theoretical vs actual inventory is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Theoretical vs actual inventory is not displayed in the Sync Inventory page");}

		try {
			if(TrackWastage.isDisplayed()) {
				test.log(LogStatus.PASS, "Track wastage, theft and spoilage is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Track wastage, theft and spoilage is not displayed in the Sync Inventory page");}

		try {
			if(KnowYourFoodCost.isDisplayed()) {
				test.log(LogStatus.PASS, "Know your food cost is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Know your food cost is not displayed in the Sync Inventory page");}

		try {
			if(SyncBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "Sync Data to Inventory button is displayed in the Sync Inventory page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Sync Data to Inventory button is not displayed in the Sync Inventory page");}

	}
	
	public void syncInventory() throws Exception {
		//Click the sync button
		SyncBtn.click();
		
		Thread.sleep(3000);
		// get the success message
		if (successMessage.getText().equals("Stay Calm, Authenticating & Syncing Inventory data")) {
			test.log(LogStatus.PASS,"Stay Calm, Authenticating & Syncing Inventory data popup displayed after click the Sync button");
		} else {
			test.log(LogStatus.FAIL,"Stay Calm, Authenticating & Syncing Inventory data popup is not displayed after click the Sync button");
		}
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message mx-2']/span")));
		
		// get the success message
		if (successMessage.getText().equals("Inventory Synced Successfully")) {
			test.log(LogStatus.INFO,"Inventory Synced Successfully popup is displayed after click the Sync button");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} 
		else if (successMessage.getText().equals("Your inventory data are not sync properly"))
		{
			test.log(LogStatus.INFO,"Your inventory data are not sync properly popup is displayed after click the Sync button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
}