package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_Purchase_Template_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;
	
	String recipeUnit, recipePrice;
	
	Utility ut=new Utility();
	
	public Inventory_Purchase_Template_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//h3[contains(.,'New Purchase Template')]")
	WebElement PurchaseTemplateTitle;
	
	@FindBy(xpath =  "//h3[contains(.,'Update Purchase Template')]")
	WebElement UpdatePurchaseTemplateTitle;
	
	@FindBy(xpath =  "//button[contains(.,'NEW PURCHASE TEMPLATE')]")
	WebElement NewPurchaseTemplateBtn;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'check_circle_outline')]")
	WebElement ActiveBtn;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'remove_circle_outline')]")
	WebElement InactiveBtn;
	
	@FindBy(xpath =  "//input[contains(@placeholder,'Search')]")
	WebElement Search;
	
	@FindBy(xpath =  "//button[contains(.,'COLUMNS')]")
	WebElement Columns;
	
	@FindBy(xpath =  "//th[contains(.,'Name')]")
	WebElement Name_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Vendor')]")
	WebElement Vendor_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Actions')]")
	WebElement Actions_Column;
	
	@FindBy(xpath =  "//button[contains(@class,'mat-custom-page')]")
	WebElement paginator;
	
	@FindBy(xpath =  "//label[contains(.,'Name')]/../../input")
	WebElement Name;
	
	@FindBy(xpath =  "//label[contains(.,'Vendor')]/../../input")
	WebElement Vendor;
	
	@FindBy(xpath =  "//div[contains(.,'Vendor Address') and contains(@class,'fw-bold')]")
	WebElement VendorAddress;
	
	@FindBy(xpath =  "//div[contains(.,'Ship To') and contains(@class,'fw-bold')]")
	WebElement ShipTo;
	
	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div/button")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement delete_Confirmation_Btn;
	
	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[3]//input")
	WebElement ItemQuantity;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[4]//input")
	WebElement UnitPrice;

	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div[5]//input")
	WebElement Price;
	
	@FindBy(xpath = "//div[.='Total']/../div[2]")
	WebElement Total;
	
	@FindBy(xpath = "//div[contains(.,'Vendor Address') and contains(@class,'fw-bold')]/../div[2]/div[1]")
	WebElement VendorName;
	
	@FindBy(xpath = "//h5[contains(.,'Items to Be Ordered')]")
	WebElement Items_To_Be_Order;
	
	@FindBy(xpath = "//div/b[contains(.,'Item')]")
	WebElement Item_Header;

	@FindBy(xpath = "//div/b[contains(.,'Brand')]")
	WebElement Brand_Header;

	@FindBy(xpath = "//div/b[contains(.,'Quantity')]")
	WebElement Quantity_Header;

	@FindBy(xpath = "//div/b[contains(.,'Unit Price')]")
	WebElement Unit_Price_Header;

	@FindBy(xpath = "(//div/b[contains(.,'Price')])[2]")
	WebElement Price_Header;
	
	@FindBy(xpath = "//div/b[contains(.,'Tax')]")
	WebElement Tax_Header;

	@FindBy(xpath = "//div/b[contains(.,'Total')]")
	WebElement Total_Header;

	@FindBy(xpath = "//button[contains(.,'SAVE') and @disabled='true']")
	WebElement Save_Btn_Disabled;
	
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	WebElement Save_Btn;
	
	@FindBy(xpath = "//button[contains(.,'UPDATE') and @disabled='true']")
	WebElement Update_Btn_Disabled;
	
	@FindBy(xpath = "//button[contains(.,'UPDATE')]")
	WebElement Update_Btn;
	
	@FindBy(xpath = "//span[contains(.,'Add Inventory Item')]")
	WebElement AddInventoryItem;

	@FindBy(xpath = "(//div[contains(@class,'selectbox-component size-stretch')]/mat-form-field)[1]")
	WebElement ItemSelection;

	@FindBy(xpath = "(//div[contains(@class,'selectbox-component size-stretch')]/mat-form-field)[3]")
	WebElement ItemSelection1;
	
	@FindBy(xpath = "//mat-icon[contains(.,'arrow_drop_up')]")
	WebElement IncreaseItem;

	@FindBy(xpath = "//mat-icon[contains(.,'arrow_drop_down')]")
	WebElement DecreaseItem;
	
	@FindBy(xpath =  "(//button[contains(@class,'iconbutton')])[1]")
	WebElement EditBtn;
	
	@FindBy(xpath =  "(//button[contains(@class,'iconbutton')])[2]")
	WebElement DeleteBtn;
	
	@FindBy(xpath =  "//p[contains(.,'Are you sure you want to delete this item?')]")
	WebElement DeleteMsg;
	
	@FindBy(xpath =  "//button[contains(@class,'iconbutton')]")
	WebElement ActivateBtn;
	
	@FindBy(xpath =  "//p[contains(.,'Are you sure you want to activate this item?')]")
	WebElement ActivateMsg;
	
	@FindBy(xpath =  "//button[contains(.,'Yes, Activate')]")
	WebElement ActivateConfirmBtn;
	
	
	
	
	
	
	
	
	
	@FindBy(xpath =  "//button[contains(.,'add_link')]")
	WebElement link_Unlink_Btn;
	
	@FindBy(xpath =  "//input[@placeholder='Select Type']")
	WebElement Select_Type;
	
	@FindBy(xpath =  "//button[contains(.,'Cancel')]")
	WebElement Cancel_Btn;
	
	@FindBy(xpath =  "(//button[contains(.,'Cancel')])[2]")
	WebElement Cancel_Btn1;
	

	@FindBy(xpath =  "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	@FindBy(xpath =  "//tbody/tr/td[2]")
	WebElement linkedStatusForFirstRow;
	
	@FindBy(xpath =  "//select-option[contains(.,'Sub Recipe')]")
	WebElement SubRecipe;
	
	@FindBy(xpath =  "//select-option[contains(.,'Not Inventory Item')]")
	WebElement NotInventoryItem;
	
	@FindBy(xpath =  "(//select-option[contains(.,'Item')])[2]")
	WebElement Item;
	
	@FindBy(xpath =  "//select-option[contains(.,'Menu Item')]")
	WebElement MenuItem;

	@FindBy(xpath =  "//button[contains(.,'Link Modifier')]")
	WebElement LinkModifierBtn;
	

	
	@FindBy(xpath =  "//b[contains(.,'Recipe Unit')]/../../../div[2]/div[2]/app-selectbox/div/mat-form-field/div/div/div/input")
	WebElement RecipeUnit;
	
	@FindBy(xpath =  "//b[contains(.,'Recipe Unit')]/../../../div[2]/div[4]/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement RecipePrice;
	
	@FindBy(xpath =  "//button[contains(.,'MODIFIERS')]")
	WebElement ModifiersTab;
	
	@FindBy(xpath =  "//span[contains(.,'Recipe Unit')]/../../../../div/div/div[2]/app-selectbox/div/mat-form-field/div/div/div/input")
	WebElement RecipeUnit1;
	
	@FindBy(xpath =  "//span[contains(.,'Recipe Unit')]/../../../../div/div/div[2]/app-selectbox/../../div[3]/span")
	WebElement RecipePrice1;
	
	@FindBy(xpath =  "//div[contains(.,'Inventory Details') and contains(@class,'mat-step-label-active')]")
	WebElement inventoryDetails;
	
	@FindBy(xpath = "//div[@class='option-list']//input[@data-placeholder='Search']")
	WebElement SearchBox_DropDown;
	
	
			
			
	
	
	public void Verify_PurchaseTemplate_Page() {
		try {
			if(NewPurchaseTemplateBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "New Purchase Template button is displayed in Purchase Template page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "New Purchase Template button is not displayed in Purchase Template page");}
		
		try {
			if(ActiveBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "Active button is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Active button is not displayed");}
		
		try {
			if(Search.isDisplayed()) {
				test.log(LogStatus.PASS, "Search field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Search field is not displayed");}
		
		try {
			if(Columns.isDisplayed()) {
				test.log(LogStatus.PASS, "Columns field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Columns field is not displayed");}
		
		try {
			if(Name_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Name column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Name column is not displayed");}
		
		try {
			if(Vendor_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Vendor Column is not displayed");}
		
		try {
			if(Actions_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Actions Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Actions Column is not displayed");}
		
	}
	
	public void VerifyTheNewPurchaseTemplatePage() {
		//Click the New Purchase Template button
		NewPurchaseTemplateBtn.click();
		
		try {
			if(PurchaseTemplateTitle.isDisplayed()) {
				test.log(LogStatus.PASS, "New Purchase Template header is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "New Purchase Template header is not displayed");}
		
		try {
			if(Name.isDisplayed()) {
				test.log(LogStatus.PASS, "Name field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Name field is not displayed");}
		
		try {
			if(Vendor.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Vendor field is not displayed");}
		
		try {
			if(VendorAddress.isDisplayed()) {
				test.log(LogStatus.PASS, "Vendor Address field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Vendor Address field is not displayed");}
		
		try {
			if(ShipTo.isDisplayed()) {
				test.log(LogStatus.PASS, "Ship To field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Ship To field is not displayed");}
		
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
			if (Tax_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Price Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Price Header is not displayed");
		}
		
		try {
			if (Total_Header.isDisplayed()) {
				test.log(LogStatus.PASS, "Price Header is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Price Header is not displayed");
		}

		try {
			if (Save_Btn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button disabled is displayed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Save button disabled is not displayed");
		}
	}
	
	public void enterTheName(String Template_Name) {
		Name.sendKeys(Template_Name);
	}
	
	public void select_Vendor() throws Exception {

		// Click the vendor input field
		Vendor.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize2 = menuList2.size();

		// create the random variable
		int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

		// Get the value
		String vendora = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(vendora);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();

	}
	
	public void Add_Inventory_Item() throws Exception {
		//Click the add inventory item
		Thread.sleep(1500);AddInventoryItem.click();
		Thread.sleep(1500);
		
		// Click the item arrow button
		ItemSelection.click();
		Thread.sleep(1500);

		// get the number options from the list
		List<WebElement> menuList1 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize1 = menuList1.size();

		if (menuSize1 > 1) {
			// create the random variable
			int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize1);

			// Get the value
			String s = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

			// Enter the value in search box
			driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(s);
			Thread.sleep(1000);

			// Click the Random option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			Thread.sleep(1500);
		} else {
			// Click the Random option from the list
			driver.findElement(By.xpath("//div[1]/select-option")).click();
			Thread.sleep(1500);
		}
		
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
				test.log(LogStatus.PASS,"Actual and expected price are same and the price is(When user click the increase button) : "+ pri1);
			} else {
				double diff = pri1 - actPri1;
				test.log(LogStatus.FAIL,"Actual and expected price are not same and the difference is(When user click the increase button) : "+ diff);
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
		List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize2 = menuList2.size();

		if (menuSize2 > 1) {
			// create the random variable
			int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize1);

			// Get the value
			String s = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

			// Enter the value in search box
			driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(s);
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
		
		Thread.sleep(1500);
		// Click the Save button
		Save_Btn.click();

		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Purchase template Saved Successfully!.")) {
			test.log(LogStatus.PASS,"Purchase template Saved Successfully!. popup displayed after click the Save button");
		} else {
			test.log(LogStatus.FAIL,"Purchase template Saved Successfully!. popup is not displayed after click the Save button");
		}
	
	}
	
	public void SearchThePurchaseTemplate(String search) {
		Search.clear();
		Search.sendKeys(search);
	}
	
	public void clickEditButton() throws Exception {
		Thread.sleep(1500);
		
		//Click the edit button
		EditBtn.click();
		
		Thread.sleep(1500);
		try {
			if(UpdatePurchaseTemplateTitle.isDisplayed()) {
				test.log(LogStatus.PASS, "Update Purchase Template header is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Update Purchase Template header is not displayed");}	
		
		try {
			if(Update_Btn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Update button disabled when user not change anything");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Update button enabled when user not change anything");}	
	}

	public void increaseOrDecreaseTheQuantity() throws Exception {
		cmp = new Common_XPaths(driver, test);
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
				test.log(LogStatus.PASS,"Actual and expected price are same and the price is(When user click the increase button) : "+ pri1);
			} else {
				double diff = pri1 - actPri1;
				test.log(LogStatus.FAIL,"Actual and expected price are not same and the difference is(When user click the increase button) : "+ diff);
			}
		}
		try {
		//Click the update button
		Update_Btn.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Purchase template updated successfully!.")) {
			test.log(LogStatus.PASS,"Purchase template updated Successfully!. popup displayed after click the Update button");
		} else {
			test.log(LogStatus.FAIL,"Purchase template updated Successfully!. popup is not displayed after click the Update button");
		}
		}
		catch (Exception e) {
			
			if(driver.findElement(By.xpath("//button[contains(.,'UPDATE')]")).isDisplayed()) {
				cmp.Click_BackspaceButton();
				
				test.log(LogStatus.FAIL,"Not able to click on Update Button");
				
			}
			
		}
	}
	
	public void deleteCancel() throws Exception {
		Thread.sleep(1500);
		
		//Click the delete button
		DeleteBtn.click();
		
		Thread.sleep(1500);
		try {
			if(DeleteMsg.isDisplayed()) {
				test.log(LogStatus.PASS, "Delete Message is displayed when user click the delete button");
			
				//Click the cancel button
				Cancel_Btn1.click();
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Delete Message is not displayed when user click the delete button");}	
	}
	
	public void delete() throws Exception {
		Thread.sleep(1500);
	
		//Click the delete button
		DeleteBtn.click();
		
		Thread.sleep(1500);
		
		//Click the delete button in the confirmation popup
		delete_Confirmation_Btn.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equalsIgnoreCase("purchase template InActivated successfully")) {
			test.log(LogStatus.PASS,"Purchase template InActivated Successfully!. popup displayed after confirm the delete option");
		} else {
			test.log(LogStatus.FAIL,"Purchase template InActivated Successfully!. popup is not displayed after confirm the delete option");
		}
	}
	
	public void clickTheActiveBtn() {
		//Click the active button
		ActiveBtn.click();
	}
	
	public void verifyTheTemplateAvailability(String na) throws Exception {
		Thread.sleep(2000);
		//verify the availability
		if(driver.findElement(By.xpath("//td/span[contains(.,'"+na+"')]")).isDisplayed()) {
			test.log(LogStatus.PASS, "The required Template is availble in the InActive page");
		}else {
			test.log(LogStatus.FAIL, "The required Template is not availble in the InActive page");
		}
	}
	
	public void clickActivateBtn() throws Exception {
		//Click the activate button
		ActivateBtn.click();
		
		Thread.sleep(1500);
		try {
			if(ActivateMsg.isDisplayed()) {
				test.log(LogStatus.PASS, "Activate Message is displayed when user click the activate button");
			
				//Click the cancel button
				Cancel_Btn1.click();
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Activate Message is not displayed when user click the activate button");}	
	}
	
	public void activate() throws Exception {
		Thread.sleep(1500);
	
		//Click the activate button
		ActivateBtn.click();
		
		Thread.sleep(1500);
		
		//Click the activate button in the confirmation popup
		ActivateConfirmBtn.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equalsIgnoreCase("purchase template Activated successfully")) {
			test.log(LogStatus.PASS,"Purchase template Activated Successfully!. popup displayed after confirm the activate option");
		} else {
			test.log(LogStatus.FAIL,"Purchase template Activated Successfully!. popup is not displayed after confirm the activate option");
		}
		
	}
	
	public void verifyTheTemplateAvailabilityInActiveStatus(String na) throws Exception {
		Thread.sleep(2000);
		//verify the availability
		if(driver.findElement(By.xpath("//td/span[contains(.,'"+na+"')]")).isDisplayed()) {
			test.log(LogStatus.PASS, "The required Template is availble in the Active page");
		}else {
			test.log(LogStatus.FAIL, "The required Template is not availble in the Active page");
		}
	}
	public void inActiveBtn() throws Exception {
		//Click the activate button
		InactiveBtn.click();
		Thread.sleep(1000);
	}
	
	
}