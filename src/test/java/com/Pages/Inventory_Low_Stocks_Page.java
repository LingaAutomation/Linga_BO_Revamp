package com.Pages;

import java.util.List;

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

public class Inventory_Low_Stocks_Page extends BasePage
{
//	SelfHealingDriver driver;
//	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;
	
	public String ItemName, MQ, AQ, Type;
	
	public int 	INn, mqq, aqq;
	
	Utility ut=new Utility();
	
	public Inventory_Low_Stocks_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//h3[contains(.,'Low Stocks')]")
	WebElement LowStocksTitle;
	
	@FindBy(xpath =  "//button[contains(.,'CREATE PURCHASE ORDER')]")
	WebElement CreatePurchaseOrder;
	
	@FindBy(xpath =  "//button[contains(.,'PREPARE SUB RECIPE')]")
	WebElement PrepareSubRecipe;
	
	@FindBy(xpath =  "//span[contains(.,'Name') and @class='header-title']")
	WebElement Name_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'Type') and @class='header-title']")
	WebElement Type_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'Min Quantity') and @class='header-title']")
	WebElement MinQuantity_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'Available Quantity') and @class='header-title']")
	WebElement AvailableQuantity_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'Inventory Unit') and @class='header-title']")
	WebElement InventoryUnit_Heading;
	
	@FindBy(xpath =  "//button[contains(.,'INVENTORY')]")
	WebElement Inventory_Heading;
	
	@FindBy(xpath =  "//button[contains(.,'SUB RECIPE')]")
	WebElement SubRecipe_Heading;
	
	@FindBy(xpath =  "//button[contains(.,'INVENTORY') and contains (@class,'active')]")
	WebElement Inventory_Heading_Active;
	
	@FindBy(xpath =  "//button[contains(.,'SUB RECIPE') and contains (@class,'active')]")
	WebElement SubRecipe_Heading_Active;
	
	@FindBy(xpath =  "(//data-grid-row/div[@id='data-grid-row']/div[1]/span)[1]")
	WebElement InventoryItem_First;
	
	@FindBy(xpath =  "(//data-grid-row/div[@id='data-grid-row']/div[3]/span)[1]")
	WebElement MinQuantity_First;
	
	@FindBy(xpath =  "(//data-grid-row/div[@id='data-grid-row']/div[4]/span)[1]")
	WebElement AvailableQuantity_First;
	
	@FindBy(xpath =  "(//data-grid-row/div[@id='data-grid-row']/div[2]/span)[1]")
	WebElement MinQuantity_First1;
	
	@FindBy(xpath =  "(//data-grid-row/div[@id='data-grid-row']/div[3]/span)[1]")
	WebElement AvailableQuantity_First1;
	
	@FindBy(xpath = "//label[contains(.,'Place Order Via')]/../../input")
	WebElement PlaceOrderVia;

	@FindBy(xpath = "//select-option[contains(.,'Email')]")
	WebElement PlaceOrderVia_Email_Option;
	
	@FindBy(xpath = "//label[contains(.,'CC')]/../../input")
	WebElement CC_input;

	@FindBy(xpath = "//p[contains(.,'Enter valid Email ID')]")
	WebElement Email_Validation_message;
	
	@FindBy(xpath = "//button[contains(@class,'delete-button')]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement delete_Confirmation_Btn;
	
	@FindBy(xpath = "//button[contains(.,'PLACE ORDER ')]")
	WebElement Place_Order_Btn;

	@FindBy(xpath = "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
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

	@FindBy(xpath = "//span[.='No Purchase Orders Found']")
	WebElement noData;
	
	@FindBy(xpath = "//span[contains(.,'RECEIVE ITEMS')]")
	WebElement ReceiveItems;
	
	@FindBy(xpath = "//label[contains(.,'Sub Recipe')]/../../input")
	WebElement SubRecipe;
	
	@FindBy(xpath = "//input[@placeholder]")
	WebElement Search;
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement Save;
	
	
	
	public void Verify_LowStocks_Page() {
		try {
			if(Inventory_Heading_Active.isDisplayed()) {
				test.log(LogStatus.PASS, "Inventory tab is activated");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Inventory tab is not activated");}
		
		try {
			if(SubRecipe_Heading.isDisplayed()) {
				test.log(LogStatus.PASS, "SubRecipe tab is available");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "SubRecipe tab is not available");}
		
		try {
			if(CreatePurchaseOrder.isDisplayed()) {
				test.log(LogStatus.PASS, "Create Purchase Order button is displayed");
				
				try {
					if(Name_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Name Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Name Column is not displayed");}
				
				try {
					if(InventoryUnit_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Inventory Unit Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Inventory Unit Column is not displayed");}
				
				try {
					if(Type_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Type Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Type Column is not displayed");}
				
				try {
					if(MinQuantity_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Min Quantity Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Min Quantity Column is not displayed");}
				
				try {
					if(AvailableQuantity_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Available Quantity Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Available Quantity Column is not displayed");}
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Create Purchase Order button is not displayed");}
			
	}

	public void verfiySubRecipeAdded() throws Exception {
		Thread.sleep(3000);
		
		String ns = InventoryItem_First.getText();
		
		String sa = MinQuantity_First1.getText();
		
		double b = Double.parseDouble(sa);
		
		b = (b * 100.00)/100.00;
		
		String sd = AvailableQuantity_First1.getText();
		
		double a = Double.parseDouble(sd);
		
		a = (a * 100.00)/100.00;
		
		if(b < a) {
			test.log(LogStatus.FAIL, "Available quantity is more than Minimum quantity for the mentioned Sub Recipe : "+ns);
		}
		
		//Click the Prepare Sub Recipe
		PrepareSubRecipe.click();
		
		Thread.sleep(25000);
		
		//Click the sub recipe option
		SubRecipe.click();
		
		//clear the search field
		Search.clear();
		
		//enter the search value
		Search.sendKeys(ns);
		
		Thread.sleep(500);
		
		//click the required option
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		String cnt = driver.findElement(By.xpath("//label[contains(.,'Quantity')]/../../input")).getAttribute("value");
		
		int Count = Integer.parseInt(cnt);
		
		if(Count > 1) {
			for(int i = 1; i < Count; i++) {
				driver.findElement(By.xpath("//div[contains(@class,'number-buttons')]/button[2]")).click();
			}
		}else if(Count < 1) {
			for(int i = Count; i < 1; i++) {
				driver.findElement(By.xpath("//div[contains(@class,'number-buttons')]/button[1]")).click();
			}
		}
		
		//Click the save button
		Save.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Sub recipe prepared successfully")) {
			test.log(LogStatus.PASS,"Sub recipe prepared successfully popup displayed after click the Save button");
		} else {
			test.log(LogStatus.FAIL,"Sub recipe prepared successfully popup is not displayed after click the Save button");
		}
		
		//Click the Low Stocks tab
		Inventory_Heading.click();
		
		Thread.sleep(5000);
		
		//Click the Sub Recipe button
		SubRecipe_Heading.click();
		
		Thread.sleep(3000);
		
		//get the difference between minimum quantity and available quantity
		double s = b - a;
		
		if(s == 1) {
			
				//GEt the name
				String itmnme =  InventoryItem_First.getText();
				
				if(!itmnme.equals(ItemName)) {
					test.log(LogStatus.PASS, "Required Item is not available, because that minimum and available quantity is same");
				}
		}
		else if(s >= 1) {
			//get The available quantity
			String avaiqu =  AvailableQuantity_First1.getText();
			
			double av = Double.parseDouble(avaiqu);
			
			double aqqq = a + 1;
			
			if(av ==  aqqq) {
				test.log(LogStatus.PASS, "Available quanity is incresed by 1 after receive the required order");
			}
		}
		
	}
	
	public void VerifyTheNewSubRecipePage() {
		//Click the Sub Recipe button
		SubRecipe_Heading.click();
		
		try {
			if(SubRecipe_Heading_Active.isDisplayed()) {
				test.log(LogStatus.PASS, "Sub Recipe tab is activated");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Sub Recipe tab is not activated");}
		
		try {
			if(PrepareSubRecipe.isDisplayed()) {
				test.log(LogStatus.PASS, "Prepare Sub Recipe tab is displayed");
				
				try {
					if(Name_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Name Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Name Column is not displayed");}
				
				try {
					if(InventoryUnit_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Inventory Unit Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Inventory Unit Column is not displayed");}
				
				try {
					if(MinQuantity_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Min Quantity Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Min Quantity Column is not displayed");}
				
				try {
					if(AvailableQuantity_Heading.isDisplayed()) {
						test.log(LogStatus.PASS, "Available Quantity Column is displayed");
					}
				}catch(Exception e) {test.log(LogStatus.FAIL, "Available Quantity Column is not displayed");}
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Prepare Sub Recipe tab is not displayed");}

	}
	
	public void verifyInventory_Purchase_Low_Stocks() throws Exception {
		//get the value
		getTheValue();
		
		//Click the create purchase order button
		clickCreatePurchaseOrder();
		
		//select the email
		select_The_Email();
		
		//place the order
		placeOrder();
		
		//get the count after order placed
		verifyTheCountAfterPlaceOrder();
		
		// receive the order
		receiveOreder();
		
		//get the value after receive the order
		verifyTheCountAfterReciveOrder();
	}
	
	
	public void clickCreatePurchaseOrder() {
		//Click the Purchase Order button
		CreatePurchaseOrder.click();
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
	
	public void getTheValue() {
		//GEt the name
		ItemName = InventoryItem_First.getText();
		
		//get the minimum quantity
		MQ = MinQuantity_First.getText();
		
		//get The available quantity
		AQ = AvailableQuantity_First.getText();
		
		int MQQ = Integer.parseInt(MQ);
		
		int AQQ = Integer.parseInt(AQ);
		
		if(MQQ == AQQ) {
			test.log(LogStatus.FAIL, "Available and Minimum quantity is same but that item still available in the Low Stocks List");
		}
	}
	
	public void placeOrder() throws Exception {
		//Verify the Item
		List<WebElement> s = driver.findElements(By.xpath("//button[contains(@class,'delete-button')]"));
		
		System.out.println("Number of rows are : "+s.size());
		
		for(int i = 2;i<=s.size();i++) {
			
			//Click the delete item(Except the first option)
			driver.findElement(By.xpath("(//button[contains(@class,'delete-button')])["+i+"]")).click();
			Thread.sleep(500);
			
			// Click the delete confirmation button
			delete_Confirmation_Btn.click();
		}
		
		String cnt = driver.findElement(By.xpath("//div[@class='row p-0 m-0 header delete-active']/../div[contains(@class,'p-relative inputs-rows')]/div[4]/app-input/div/div/mat-form-field/div/div/div/input")).getAttribute("value");
		
		int Count = Integer.parseInt(cnt);
		
		if(Count > 1) {
			for(int i = 1; i < Count; i++) {
				driver.findElement(By.xpath("//div[contains(@class,'p-relative inputs-rows')]/div/app-input/div/div/div/button[2]")).click();
			}
		}else if(Count < 1) {
			for(int i = Count; i < 1; i++) {
				driver.findElement(By.xpath("//div[contains(@class,'p-relative inputs-rows')]/div/app-input/div/div/div/button[1]")).click();
			}
		}
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1500);
		// Click the place order button
		Place_Order_Btn.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("html")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.xpath("html")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.xpath("html")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.xpath("html")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Purchase order saved successfully!.")) {
			test.log(LogStatus.PASS,
					"Purchase order saved successfully!. popup displayed after click the purchase order button");
		} else {
			test.log(LogStatus.FAIL,
					"Purchase order saved successfully!. popup is not displayed after click the purchase order button");
		}
	}
	
	public void verifyTheCountAfterPlaceOrder() {

		//GEt the name
		String itmnme =  InventoryItem_First.getText();
		
		//get the minimum quantity
		String minqu = MinQuantity_First.getText();
		
		//get The available quantity
		String avaiqu =  AvailableQuantity_First.getText();
		
		if(itmnme.equals(ItemName) && minqu.equals(MQ) && avaiqu.equals(AQ)) {
			test.log(LogStatus.PASS, "Before and After Create Purchase Order the menu item name, minimum quantity and available quantity values are not getting change(Without Receive the order)");
		
			mqq = Integer.parseInt(minqu);
			
			aqq = Integer.parseInt(avaiqu);
		}
		else {
			test.log(LogStatus.FAIL, "Before and After Create Purchase Order the menu item name, minimum quantity and available quantity values are getting change(Without Receive the order)");
		}
	}
	
	public void verifyTheCountAfterReciveOrder() throws Exception {

		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "lowStocks");

		Thread.sleep(5000);
		
		//get the difference between minimum quantity and available quantity
		int s = mqq - aqq;
		
		if(s == 1) {
			
				//GEt the name
				String itmnme =  InventoryItem_First.getText();
				
				if(!itmnme.equals(ItemName)) {
					test.log(LogStatus.PASS, "Required Item is not available, because that minimum and available quantity is same");
				}
		}
		else if(s >= 1) {
			//get The available quantity
			String avaiqu =  AvailableQuantity_First.getText();
			
			int av = Integer.parseInt(avaiqu);
			
			int aqqq = aqq + 1;
			
			if(av ==  aqqq) {
				test.log(LogStatus.PASS, "Available quanity is incresed by 1 after receive the required order");
			}
		}
		
		
	}
	
	public void receiveOreder() throws Exception {
		//Navigate to purchase order screen
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "purchases/purchaseOrders");

		Thread.sleep(8000);
		
		try {
			if (noData.isDisplayed()) {
				test.log(LogStatus.INFO, "No Purchase Orders Found message is displayed when user gives the order from low stocks page");
			}
		} catch (Exception d) {
			// Click the action button
			actionBtn.click();
			Thread.sleep(1500);

			if (Print_Opt.isDisplayed() && Edit_Opt.isDisplayed() && Receive_Opt.isDisplayed() && Cancel_Opt.isDisplayed()
					&& CheckLogs_Opt.isDisplayed() && RepeatOrder_Opt.isDisplayed() && SaveAsTemplate_Opt.isDisplayed()) {
				test.log(LogStatus.INFO, "All the required options are displayed");
				
				//CLICK the receive option
				Receive_Opt.click();Thread.sleep(1500);
				
				
				List<WebElement> de = driver.findElements(By.xpath("//div[@class='row p-0 m-0 header']/../div[contains(@class,'p-relative inputs-rows')]/div/app-input/div/div/div"));
				
				if(de.size()==1) {
					test.log(LogStatus.PASS, "Required Inventory Item only displayed, in the Receive Purchase Order Page");
				}else {
					int ss = de.size()-1;
					test.log(LogStatus.FAIL, "Unwanted Inventory Item also displayed, in the Receive Purchase Order Page and the unwanted items count is : "+ss);
				}
				
				for(int i = 2; i <= de.size();i++) {
					//click the up arrow button
					String se = driver.findElement(By.xpath("(//div[@class='row p-0 m-0 header']/../div[contains(@class,'p-relative inputs-rows')]/div[7]/app-input/div/div/mat-form-field/div/div/div/input)["+i+"]")).getAttribute("value");
					System.out.println("Quan Count is "+i+" : "+se);
					
					int ss = Integer.parseInt(se);
					
					if(ss != 0) {
						for(int j = ss; j > 0; j--) {
							test.log(LogStatus.INFO, "That unwanted Inventory Item count is getting down/increase");
							
							//click the down arrow
							driver.findElement(By.xpath("(//div[@class='row p-0 m-0 header']/../div[contains(@class,'p-relative inputs-rows')]/div/app-input/div/div/div/button[2])["+i+"]")).click();
						}
					}
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
				
				Thread.sleep(2500);
				// get the success message
				if (successMessage.getText().equals("Receive information updated.")) {
					test.log(LogStatus.PASS,
							"Receive information updated. popup displayed after click the Receive Items button");
				} else {
					test.log(LogStatus.FAIL,
							"Receive information updated. popup is not displayed after click the Receive Items button and the message is "+successMessage.getText());
				}
				
				Thread.sleep(2000);
				
				
				
			} else {
				test.log(LogStatus.FAIL, "All the required options are not displayed");
			}
		}	
	}
}