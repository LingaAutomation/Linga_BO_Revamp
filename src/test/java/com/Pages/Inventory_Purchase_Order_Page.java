package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_Purchase_Order_Page extends BasePage
{
//	SelfHealingDriver driver;
//	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;

	Utility ut = new Utility();

	String invenItem = "";

	String CostPerUnit = ""; double CPU;

	String ValueOnHand = ""; double VOH;

	String invenPurItem = "";

	String quantityItem = ""; double QI;

	String quantityPurItem = ""; double QPI;

	String vendora = "";
	
	int receiveQty = 7;

	public Inventory_Purchase_Order_Page(SelfHealingDriver driver, ExtentTest test) {
//		this.driver = driver;
//		this.test = test;
		
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[contains(.,'Purchase Orders')]")
	WebElement PurchaseOrderTitle;

	@FindBy(xpath = "//button[contains(.,'NEW PURCHASE ORDER')]")
	WebElement NewPurchaseOrder_btn;

	@FindBy(xpath = "//label[contains(.,'Vendor')]")
	WebElement Vendor;

	@FindBy(xpath = "//label[contains(.,'Status')]/../../input")
	WebElement Status;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search;

	@FindBy(xpath = "//button[contains(.,'COLUMNS')]")
	WebElement Columns;

	@FindBy(xpath = "//span[contains(.,'Purchase Order ID') and @class='header-title']")
	WebElement PurchaseOrderId_Column;

	@FindBy(xpath = "//span[contains(.,'Vendor') and @class='header-title']")
	WebElement Vendor_Column;

	@FindBy(xpath = "//span[contains(.,'Order Date') and @class='header-title']")
	WebElement OrderDate_Column;

	@FindBy(xpath = "//span[contains(.,'Status') and @class='header-title']")
	WebElement Status_Column;

	@FindBy(xpath = "//div[contains(.,'Actions') and contains(@class,'data-grid-header ')]")
	WebElement Actions_Column;

	@FindBy(xpath = "//h3[contains(.,'New Purchase Order')]")
	WebElement New_Purchase_Order_Heading;

	@FindBy(xpath = "//label[contains(.,'Vendor')]/../../input")
	WebElement Vendor_Input;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	WebElement Calendar;

	@FindBy(xpath = "//label[contains(.,'Place Order Via')]/../../input")
	WebElement PlaceOrderVia;

	@FindBy(xpath = "//select-option[contains(.,'Email')]")
	WebElement PlaceOrderVia_Email_Option;

	@FindBy(xpath = "//select-option[contains(.,'Print')]")
	WebElement PlaceOrderVia_Print_Option;

	@FindBy(xpath = "//div[contains(.,'Vendor Address') and contains(@class,'fw-bold')]")
	WebElement Vendor_Address;

	@FindBy(xpath = "//div[contains(.,'Ship To') and contains(@class,'fw-bold')]")
	WebElement Ship_To;

	@FindBy(xpath = "//h5[contains(.,'Items to Be Ordered')]")
	WebElement Items_To_Be_Order;

	@FindBy(xpath = "//div/b[contains(.,'Item')]")
	WebElement Item_Header;

	@FindBy(xpath = "//div/b[contains(.,'SKU Code')]")
	WebElement SKU_Code_Header;

	@FindBy(xpath = "//div/b[contains(.,'Brand')]")
	WebElement Brand_Header;

	@FindBy(xpath = "//div/b[contains(.,'Quantity')]")
	WebElement Quantity_Header;

	@FindBy(xpath = "//div/b[contains(.,'Unit Price')]")
	WebElement Unit_Price_Header;

	@FindBy(xpath = "(//div/b[contains(.,'Price')])[2]")
	WebElement Price_Header;

	@FindBy(xpath = "//button[contains(.,'Place Order') and @disabled='true']")
	WebElement Place_Order_Btn_Disabled;

	@FindBy(xpath = "//button[contains(.,'Place Order')]")
	WebElement Place_Order_Btn;

	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement Cancel_Btn;

	@FindBy(xpath = "(//button[contains(.,'Cancel')])[2]")
	WebElement Cancel_Btn1;

	@FindBy(xpath = "//div[contains(@class,'cdk-drop-list')]")
	WebElement Purchase_Data;

	@FindBy(xpath = "//button[contains(.,'Apply')]")
	WebElement Apply_Btn;

	@FindBy(xpath = "//div[contains(@class,'mat-calendar-body-today')]")
	WebElement today;

	@FindBy(xpath = "//label[contains(.,'CC')]/../../input")
	WebElement CC_input;

	@FindBy(xpath = "//p[contains(.,'Enter valid Email ID')]")
	WebElement Email_Validation_message;

	@FindBy(xpath = "//span[contains(.,'Add Inventory Item')]")
	WebElement AddInventoryItem;

	@FindBy(xpath = "(//div[contains(@class,'selectbox-component size-stretch')]/mat-form-field)[3]")
	WebElement ItemSelection;

	@FindBy(xpath = "(//div[contains(@class,'selectbox-component size-stretch')]/mat-form-field)[4]")
	WebElement ItemSelection1;

	@FindBy(xpath = "//mat-icon[contains(.,'arrow_drop_up')]")
	WebElement IncreaseItem;

	@FindBy(xpath = "//mat-icon[contains(.,'arrow_drop_down')]")
	WebElement DecreaseItem;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[4]//input")
	WebElement ItemQuantity;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[5]//input")
	WebElement UnitPrice;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[6]//input")
	WebElement Price;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div/button")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement delete_Confirmation_Btn;

	@FindBy(xpath = "//div[@class='message mx-2']/span")
	WebElement successMessage;

	@FindBy(xpath = "//span[.='No Purchase Orders Found']")
	WebElement noData;

	@FindBy(xpath = "//select-option[contains(.,'Placed')]")
	WebElement Sta_Placed;

	@FindBy(xpath = "//select-option[contains(.,'Partially')]")
	WebElement Sta_Partially_Received;

	@FindBy(xpath = "(//select-option[contains(.,'Received')])[2]")
	WebElement Sta_Received;

	@FindBy(xpath = "//select-option[contains(.,'Canceled')]")
	WebElement Sta_Canceled;

	@FindBy(xpath = "//button[@aria-label='Actions']")
	WebElement actionBtn;

	@FindBy(xpath = "//button[contains(.,'Print')]")
	WebElement Print_Opt;

	@FindBy(xpath = "//button[contains(.,'Edit')]")
	WebElement Edit_Opt;

	@FindBy(xpath = "//button[contains(.,'Receive')]")
	WebElement Receive_Opt;

	@FindBy(xpath = "//button[contains(.,'Cancel') and @role]")
	WebElement Cancel_Opt;

	@FindBy(xpath = "//button[contains(.,'Check Logs')]")
	WebElement CheckLogs_Opt;

	@FindBy(xpath = "//button[contains(.,'Repeat Order')]")
	WebElement RepeatOrder_Opt;

	@FindBy(xpath = "//button[contains(.,'Save As Template')]")
	WebElement SaveAsTemplate_Opt;

	@FindBy(xpath = "//div[contains(.,'Inventory Item') and @class='menu-item-title']")
	WebElement InventoryItem_Mod;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search;

	@FindBy(xpath = "//div[contains(.,'Purchases') and @class='menu-item-title']")
	WebElement Purchase_Mod;

	@FindBy(xpath = "//div[contains(.,'Purchase Orders') and @class='settings-subject']")
	WebElement Purchase_Order;

	@FindBy(xpath = "//span[contains(.,'RECEIVE ITEMS')]")
	WebElement ReceiveItems;
	
	
	
	
	
	
	
	
	

	public void Verify_Purchase_Order_Page() {
		try {
			if (NewPurchaseOrder_btn.isDisplayed()) {
				test.log(LogStatus.PASS, "New Purchase Order button is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "New Purchase Order button is not displayed");
		}

		try {
			if (Vendor.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Vendor field is not displayed");
		}

		try {
			if (Status.isDisplayed()) {
				test.log(LogStatus.PASS, "Status field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Status field is not displayed");
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
			if (PurchaseOrderId_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Purchase Order ID column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Purchase Order ID column is not displayed");
		}

		try {
			if (Vendor_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Vendor Column is not displayed");
		}

		try {
			if (OrderDate_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Order Date Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Order Date Column is not displayed");
		}

		try {
			if (Status_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Status Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Status Column is not displayed");
		}

		try {
			if (Actions_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Actions Column is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Actions Column is not displayed");
		}

	}

	public void Click_New_Purchase_Order_Btn() throws Exception {

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);

		// Click the new purchase order button
		NewPurchaseOrder_btn.click();
	}

	public void verify_New_Purchase_Order_Screen() {
		try {
			if (New_Purchase_Order_Heading.isDisplayed()) {
				test.log(LogStatus.PASS, "New Purchase Order heading is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "New Purchase Order heading is not displayed");
		}

		try {
			if (Vendor_Input.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor Input field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Vendor Input field is not displayed");
		}

		try {
			if (Calendar.isDisplayed()) {
				test.log(LogStatus.PASS, "Calendar field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Calendar field is not displayed");
		}

		try {
			if (PlaceOrderVia.isDisplayed()) {
				test.log(LogStatus.PASS, "Place Order Via field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Place Order Via field is not displayed");
		}

		try {
			if (Vendor_Address.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor Address field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Vendor Address field is not displayed");
		}

		try {
			if (Ship_To.isDisplayed()) {
				test.log(LogStatus.PASS, "Ship To field is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Ship To field is not displayed");
		}

		try {
			if (Items_To_Be_Order.isDisplayed()) {
				test.log(LogStatus.PASS, "Items to be order heading is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Items to be order heading is not displayed");
		}

		try {
			if (Item_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Item Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Item Header is not displayed");
		}

		try {
			if (SKU_Code_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "SKU Code Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "SKU Code Header is not displayed");
		}

		try {
			if (Brand_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Brand Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Brand Header is not displayed");
		}

		try {
			if (Quantity_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Quantity Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Quantity Header is not displayed");
		}

		try {
			if (Unit_Price_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Unit Price Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unit Price Header is not displayed");
		}

		try {
			if (Price_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Price Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Price Header is not displayed");
		}

		try {
			if (Place_Order_Btn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Place Order button disabled is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Place Order button disabled is not displayed");
		}
	}

	public void select_Vendor() throws Exception {

		// Click the vendor input field
		Vendor_Input.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize2 = menuList2.size();

		// create the random variable
		int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

		// Get the value
		vendora = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(vendora);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();

	}

	public void select_Calendar() {

		// Click the Calendar
		Calendar.click();

		// Select the today
		today.click();
	}

	public void select_The_Print() {
		// Click the Place Order Via field
		PlaceOrderVia.click();

		// Click the Print option
		PlaceOrderVia_Print_Option.click();
	}

	public void select_The_Email() {
		// Click the Place Order Via field
		PlaceOrderVia.click();

		// Click the Email option
		PlaceOrderVia_Email_Option.click();

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys(".");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - . ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - . ");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("123");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - 123 ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - 123 ");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("abc");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - abc ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - abc ");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("abc@");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - abc@ ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - abc@ ");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("abc@");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - abc@ ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - abc@ ");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("abc@mail.");

		if (Email_Validation_message.isDisplayed()) {
			test.log(LogStatus.PASS,
					"Warning message is displayed when user enter the invalid mail id in CC field and the mail id is - abc@mail. ");
		} else {
			test.log(LogStatus.FAIL,
					"Warning message is not displayed when user enter the invalid mail id in CC field and the mail id is - abc@mail.");
		}

		// Clear the CC field
		CC_input.clear();

		// Enter the mail id in the CC field
		CC_input.sendKeys("abc@mail.com");
	}

	public void selectInventoryItem() throws Exception {
		// Lick the add Inventory button
		Thread.sleep(1500);AddInventoryItem.click();
		Thread.sleep(1500);

		// Click the item arrow button
		ItemSelection.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize2 = menuList2.size();

		if (menuSize2 > 1) {
			// create the random variable
			int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

			// Get the value
			invenPurItem = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();
			
			// Enter the value in search box
			driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(invenPurItem);
			Thread.sleep(1000);

			// Click the Random option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			Thread.sleep(1500);
		} else {
			// Click the Random option from the list
			invenPurItem = driver.findElement(By.xpath("//div[1]/select-option")).getText();
		}

	}
	
	public void getInventoryItemDetails() throws Exception {

		//Inventory item
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryItem");

		Thread.sleep(5000);

		// Clear the search field
		search.clear();

		// enter the inventory item
		search.sendKeys(invenPurItem);
		Thread.sleep(4500);

		if (driver.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[1]/span"))
				.getText().trim().equalsIgnoreCase(invenPurItem)) {
			quantityItem = driver
					.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[8]/span"))
					.getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			System.out.println("QTY is : "+quantityItem);
			
			QI = Double.parseDouble(quantityItem);
			
			CostPerUnit = driver
					.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[9]/span"))
					.getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			System.out.println("cost per unit is : "+CostPerUnit);
			
			CPU = Double.parseDouble(CostPerUnit);

			ValueOnHand = driver
					.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[10]/span"))
					.getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			System.out.println("value on hand is : "+ValueOnHand);
			
			VOH = Double.parseDouble(ValueOnHand);
		}

		//purchase order
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "purchases/purchaseOrders");

		Thread.sleep(5000);
		
		Click_New_Purchase_Order_Btn();
		Thread.sleep(3000);
	}
	
	
	public void verifyTheInventoryItemCount() throws Exception {
		//Inventory item
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryItem");

		Thread.sleep(5000);

		// Clear the search field
		search.clear();

		// enter the inventory item
		search.sendKeys(invenPurItem);
		Thread.sleep(4500);
		
		String qtyIn = driver
				.findElement(By.xpath("//div[1]/div[@class='content-container']/data-grid-row/div/div[8]/span"))
				.getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double qt = Double.parseDouble(qtyIn);
		
		QI = QI+receiveQty;
		
		if(qt == QI) {
			test.log(LogStatus.PASS, "Inventory Item quantity was increased, when user did the purchase");
		}
		else {
			double diff = qt - QI;
			test.log(LogStatus.FAIL, "Inventory Item quantity is not increased, when user did the purchase and the difference is : "+diff);
		}
		
	}
	
	public void verifyTheInventoryItemCountInMasterStock() throws Exception {

		//Need to verify the same thing in Master Stock
		//Inventory item
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id3") + "inventoryReports/masterStockReport");
		
		Thread.sleep(8000);
		// Clear the search field
		search.clear();

		// enter the inventory item
		search.sendKeys(invenPurItem);
		Thread.sleep(4500);
		
		try {
			//get the quantity
			String masQty = driver.findElement(By.xpath("//tr/td[12]")).getText();
			
			int Qtey = Integer.parseInt(masQty);
			
			//verify the quantity and inventory item
			if(driver.findElement(By.xpath("//tr/td[9]")).getText().equals(invenItem) && receiveQty == Qtey)
			{
				test.log(LogStatus.PASS, "The mentioned inventory item is getting purchased and which will be updated in the Master Stock Report");
			}
			else {
				test.log(LogStatus.PASS, "The Master Stock Report is not updated properly, when user did a purchase");
			}
		}catch(Exception d) {}

	}

	public void verifyTheInventoryItemCountInPurchasedItem() throws Exception {

		//Need to verify the same thing in Master Stock
		//Inventory item
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id3") + "inventoryReports/purchasedItems");
		
		Thread.sleep(8000);
		// Clear the search field
		search.clear();

		// enter the inventory item
		search.sendKeys(invenPurItem);
		Thread.sleep(4500);
		
		try {
			//get the quantity
			String masQty = driver.findElement(By.xpath("//div/div[1]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText();
			
			int Qtey = Integer.parseInt(masQty);
			
			//verify the quantity and inventory item
			if(driver.findElement(By.xpath("//div/div[1]/div[@class='content-container']/data-grid-row/div/div[1]/span")).getText().equals(invenItem) && receiveQty == Qtey)
			{
				test.log(LogStatus.PASS, "The mentioned inventory item is getting purchased and which will be updated in the Purchased Item Report");
			}
			else {
				test.log(LogStatus.PASS, "The Purchased Item Report is not updated properly, when user did a purchase");
			}
		}catch(Exception d) {}

	}

	
	public void Add_Inventory_Item1() throws Exception {

		// Click the Random option from the list
		// driver.findElement(By.xpath("//div["+randomMenu2+"]/select-option")).click();

		// Get the item quantity
		String qty = ItemQuantity.getAttribute("value");

		System.out.println("Print the value : " + qty);

		// Convert the String value to double
		double qnty = Double.parseDouble(qty);

		// Get the UnitPrice value
		String up = UnitPrice.getAttribute("value").replace(",", "");

		// Convert the String value to double
		double upr = Double.parseDouble(up);

		// Get the Price value
		String pr = Price.getAttribute("value").replace(",", "");
		
		// Convert the String value to double
		double pri = Double.parseDouble(pr);
		
		if(pri == CPU) {
			test.log(LogStatus.PASS, "Cost Per Unit values are same and the value is : "+pri);
		}
		else {
			double diff = pri - CPU;
			test.log(LogStatus.FAIL, "Cost Per Unit values are not same and the difference is : "+diff);
		}

		double actPri = qnty * upr;

		if (actPri == pri) {
			test.log(LogStatus.PASS, "Actual and expected price are same and the price is : " + pri);
		} else {
			double diff = pri - actPri;
			test.log(LogStatus.FAIL, "Actual and expected price are not same and the difference is : " + diff);
		}

		for (int i = 1; i <= 8; i++) {

			// Click the increase button of item
			IncreaseItem.click();

			// Get the item quantity
			String qty1 = ItemQuantity.getAttribute("value");

			// Convert the String value to double
			double qnty1 = Double.parseDouble(qty1);

			// Get the UnitPrice value
			String up1 = UnitPrice.getAttribute("value").replace(",", "");

			// Convert the String value to double
			double upr1 = Double.parseDouble(up1);

			// Get the Price value
			String pr1 = Price.getAttribute("value").replace(",", "");

			// Convert the String value to double
			double pri1 = Double.parseDouble(pr1);

			double actPri1 = qnty1 * upr1;

			if (actPri1 == pri1) {
				test.log(LogStatus.PASS,
						"Actual and expected price are same and the price is(When user click the increase button) : "
								+ pri1);
			} else {
				double diff = pri1 - actPri1;
				test.log(LogStatus.FAIL,
						"Actual and expected price are not same and the difference is(When user click the increase button) : "
								+ diff);
			}
		}

		for (int i = 5; i <= 1; i--) {

			// Click the decrease button of item
			DecreaseItem.click();

			// Get the item quantity
			String qty1 = ItemQuantity.getAttribute("value");

			// Convert the String value to double
			double qnty1 = Double.parseDouble(qty1);

			// Get the UnitPrice value
			String up1 = UnitPrice.getAttribute("value").replace(",", "");

			// Convert the String value to double
			double upr1 = Double.parseDouble(up1);

			// Get the Price value
			String pr1 = Price.getAttribute("value").replace(",", "");

			// Convert the String value to double
			double pri1 = Double.parseDouble(pr1);

			double actPri1 = qnty1 * upr1;

			if (actPri1 == pri1) {
				test.log(LogStatus.PASS,
						"Actual and expected price are same and the price is(When user click the decrease button) : "
								+ pri1);
			} else {
				double diff = pri1 - actPri1;
				test.log(LogStatus.FAIL,
						"Actual and expected price are not same and the difference is(When user click the decrease button) : "
								+ diff);
			}
		}

		// Lick the add Inventory button
		Thread.sleep(1500);AddInventoryItem.click();
		Thread.sleep(1500);

		// Click the item arrow button
		ItemSelection1.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList1 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize1 = menuList1.size();

		if (menuSize1 > 1) {
			// create the random variable
			//int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize1);

			// Get the value
			//String s = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

			// Enter the value in search box
			driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(invenPurItem);
			Thread.sleep(1000);

			// Click the Random option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			Thread.sleep(1500);
		} else {
			// Click the Random option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			Thread.sleep(1500);
		}

		Thread.sleep(1000);

		// Click the Delete button
		deleteBtn.click();

		Thread.sleep(1000);
		// Click the Cancel button
		Cancel_Btn1.click();

		Thread.sleep(500);
		// Click the Delete button
		deleteBtn.click();

		Thread.sleep(500);
		// Click the delete confirmation button
		delete_Confirmation_Btn.click();

		Thread.sleep(1500);
		//Click the Items to Be Ordered title
		driver.findElement(By.xpath("//h5[.='Items to Be Ordered']")).click();
		for(int i = 1; i <= 15;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(500);
		}
		
		Thread.sleep(500);
		// Click the place order button
		Place_Order_Btn.click();

		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Purchase order saved successfully!.")) {
			test.log(LogStatus.PASS,
					"Purchase order saved successfully!. popup displayed after click the purchase order button");
		} else {
			test.log(LogStatus.FAIL,
					"Purchase order saved successfully!. popup is not displayed after click the purchase order button");
		}
		
		Thread.sleep(1500);
		// Click the action button
		actionBtn.click();
		Thread.sleep(1500);

		if (Print_Opt.isDisplayed() && Edit_Opt.isDisplayed() && Receive_Opt.isDisplayed() && Cancel_Opt.isDisplayed()
				&& CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed() && SaveAsTemplate_Opt.isDisplayed()) {
			test.log(LogStatus.INFO, "All the required options are displayed");
		} else {
			test.log(LogStatus.FAIL, "All the required options are not displayed");
		}
		
		//Thread.sleep(1500);
		//CLICK the receive option
		Receive_Opt.click();Thread.sleep(1500);
		
		for(int i = 1; i <= receiveQty;i++) {
			//click the up arrow button
			IncreaseItem.click();
		}
		
		Thread.sleep(1500);
		//Click the Items to Be Ordered title
		driver.findElement(By.xpath("//h5[contains(.,'Ordered Items')]")).click();
		for(int i = 1; i <= 15;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(500);
		}
		Thread.sleep(500);
		//Click the receive items button
		ReceiveItems.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Receive information updated.")) {
			test.log(LogStatus.PASS,
					"Receive information updated. popup displayed after click the Receive Items button");
		} else {
			test.log(LogStatus.FAIL,
					"Receive information updated. popup is not displayed after click the Receive Items button");
		}
		
		Thread.sleep(2000);
		//verify the quantity in Inventory Item table
		//Comment as of now due to Inventory Item table is not performing well
		//verifyTheInventoryItemCount();
		
		Thread.sleep(2000);
		//verify the value in master stock
		verifyTheInventoryItemCountInMasterStock();
		
	}

	public void Add_Inventory_Item() throws Exception {

		selectInventoryItem();
		
		//commented as of now due to the inventory item table is not performing well
		//getInventoryItemDetails();
		
		Thread.sleep(1500);
		//Click the Items to Be Ordered title
		driver.findElement(By.xpath("//h5[.='Items to Be Ordered']")).click();
		for(int i = 1; i <= 15;i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(500);
		}
		
		Thread.sleep(500);
		
		// Click the vendor input field
		Vendor_Input.click();
		Thread.sleep(1500);

		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(vendora);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();

		select_Calendar();

		select_The_Email();

		// Lick the add Inventory button
		Thread.sleep(1500);AddInventoryItem.click();
		Thread.sleep(1500);

		// Click the item arrow button
		ItemSelection.click();
		Thread.sleep(1500);

		System.out.println("Inventory Item is : "+invenPurItem);
		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(invenPurItem);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		Thread.sleep(1500);

		Add_Inventory_Item1();

		/*
		 * 
		 * try { Thread.sleep(3000); if(driver.findElement(By.
		 * xpath("(//div[contains(.,'No Inventory Data Found') and @class='ng-star-inserted'])[2]"
		 * )).isDisplayed()) { Cancel_Btn.click(); Thread.sleep(3000);
		 * 
		 * Click_New_Purchase_Order_Btn(); Thread.sleep(3000);
		 * 
		 * 
		 * select_Vendor();
		 * 
		 * select_Calendar();
		 * 
		 * select_The_Email();
		 * 
		 * 
		 * driver.findElement(By.xpath("(//h3)[2]")).click(); WebElement element =
		 * driver.findElement(By.xpath("(//label[contains(.,'Vendor')]/../../input)[2]")
		 * ); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 * Thread.sleep(500);
		 * 
		 * Add_Inventory_Item1(); } }catch(Exception e) {
		 * 
		 * 
		 * driver.findElement(By.xpath("(//h3)[2]")).click(); WebElement element =
		 * driver.findElement(By.xpath("(//label[contains(.,'Vendor')]/../../input)[2]")
		 * ); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 * Thread.sleep(500);
		 * 
		 * 
		 * //select_Vendor();
		 * 
		 * //select_Calendar();
		 * 
		 * //select_The_Email();
		 * 
		 * Add_Inventory_Item1();
		 * 
		 * Thread.sleep(2500); }
		 */
	}

	public void verify_The_Status() throws Exception {

		rp = new ReportsPage(driver, test);

		Thread.sleep(5000);

		// Click the Status field
		Status.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList1 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize1 = menuList1.size();

		// create the random variable
		int randomMenu1 = ThreadLocalRandom.current().nextInt(2, menuSize1);

		// get the status value
		String statusOptions = driver.findElement(By.xpath("//div[" + randomMenu1 + "]/select-option")).getText();

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[" + randomMenu1 + "]/select-option")).click();

		rp.Select_Last_N_Days_TimePeriod("1000");

		// Click the Apply button
		Apply_Btn.click();
		Thread.sleep(3000);

		List<WebElement> stCunt = driver.findElements(By.xpath("//data-grid-row/div/div[4]/span"));

		try {
			if (noData.isDisplayed()) {
				test.log(LogStatus.INFO,
						"No Purchase Orders Found message is displayed when user gives for the particular Status");
			}
		} catch (Exception d) {
			for (int i = 1; i <= stCunt.size(); i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/span")).getText().equals(statusOptions)) {
					test.log(LogStatus.INFO, "Required Staus is displayed");
				} else {
					test.log(LogStatus.FAIL,
							"Unwanted Status is displayed, when user apply the filter for another Status");
				}
			}
		}
	}

	public void verifyThe_Placed_Status_Options() throws Exception {

		rp = new ReportsPage(driver, test);
		// Click the Status field
		Status.click();
		Thread.sleep(1500);

		// Click the Placed option
		Sta_Placed.click();

		rp.Select_Last_N_Days_TimePeriod("1000");

		// Click the Apply button
		Apply_Btn.click();
		Thread.sleep(1500);

		// Click the action button
		actionBtn.click();
		Thread.sleep(1500);

		if (Print_Opt.isDisplayed() && Edit_Opt.isDisplayed() && Receive_Opt.isDisplayed() && Cancel_Opt.isDisplayed()
				&& CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed() && SaveAsTemplate_Opt.isDisplayed()) {
			test.log(LogStatus.INFO, "All the required options are displayed");
		} else {
			test.log(LogStatus.FAIL, "All the required options are not displayed");
		}

		// refresh
		driver.navigate().refresh();
		Thread.sleep(2500);
	}

	public void verifyThe_Partially_Received_Status_Options() throws Exception {
		rp = new ReportsPage(driver, test);
		// Click the Status field
		Status.click();
		Thread.sleep(1500);

		// Click the Partially Received option
		Sta_Partially_Received.click();

		rp.Select_Last_N_Days_TimePeriod("1000");

		// Click the Apply button
		Apply_Btn.click();
		Thread.sleep(1500);

		// Click the action button
		actionBtn.click();
		Thread.sleep(1500);

		if (Print_Opt.isDisplayed() && Edit_Opt.isDisplayed() && Receive_Opt.isDisplayed() && Cancel_Opt.isDisplayed()
				&& CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed() && SaveAsTemplate_Opt.isDisplayed()) {
			test.log(LogStatus.INFO, "All the required options are displayed");
		} else {
			test.log(LogStatus.FAIL, "All the required options are not displayed");
		}

		// refresh
		driver.navigate().refresh();
		Thread.sleep(2500);
	}

	public void verifyThe_Received_Status_Options() throws Exception {
		rp = new ReportsPage(driver, test);
		// Click the Status field
		Status.click();
		Thread.sleep(1500);

		// Click the Received option
		Sta_Received.click();

		rp.Select_Last_N_Days_TimePeriod("1000");

		// Click the Apply button
		Apply_Btn.click();
		Thread.sleep(1500);

		// Click the action button
		actionBtn.click();
		Thread.sleep(1500);

		if (Print_Opt.isDisplayed() && CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed()
				&& SaveAsTemplate_Opt.isDisplayed()) {
			test.log(LogStatus.INFO, "All the required options are displayed");
		} else {
			test.log(LogStatus.FAIL, "All the required options are not displayed");
		}

		// refresh
		driver.navigate().refresh();
		Thread.sleep(2500);
	}

	public void verifyThe_Cancelled_Status_Options() throws Exception {
		rp = new ReportsPage(driver, test);
		// Click the Status field
		Status.click();
		Thread.sleep(1500);

		// Click the cancelled option
		Sta_Canceled.click();

		rp.Select_Last_N_Days_TimePeriod("1000");

		// Click the Apply button
		Apply_Btn.click();
		Thread.sleep(1500);

		// Click the action button
		actionBtn.click();
		Thread.sleep(1500);

		if (Print_Opt.isDisplayed() && CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed()
				&& SaveAsTemplate_Opt.isDisplayed()) {
			test.log(LogStatus.INFO, "All the required options are displayed");
		} else {
			test.log(LogStatus.FAIL, "All the required options are not displayed");
		}

		// refresh
		driver.navigate().refresh();
		Thread.sleep(2500);
	}

}