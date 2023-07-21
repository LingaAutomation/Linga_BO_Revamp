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

public class Inventory_InventoryModifiers_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;
	
	String recipeUnit, recipePrice;
	
	Utility ut=new Utility();
	
	public Inventory_InventoryModifiers_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//h3[contains(.,'Inventory Modifiers')]")
	WebElement InventoryModifiersTitle;
	
	@FindBy(xpath =  "//div[contains(@class,'progress-bar-element')]")
	WebElement StatusBar;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'check_circle_outline')]")
	WebElement ActiveBtn;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'remove_circle_outline')]")
	WebElement InactiveBtn;
	
	@FindBy(xpath =  "//input[contains(@data-placeholder,'Search')]")
	WebElement Search;
	
	@FindBy(xpath =  "//button[contains(.,'COLUMNS')]")
	WebElement Columns;
	
	@FindBy(xpath =  "//th[contains(.,'Name')]")
	WebElement Name_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Link Status')]")
	WebElement LinkStatus_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Actions')]")
	WebElement Actions_Column;
	
	@FindBy(xpath =  "//button[contains(@class,'mat-custom-page')]")
	WebElement paginator;
	
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
	
	@FindBy(xpath =  "(//button[contains(@class,'iconbutton')])[1]")
	WebElement EditBtn;
	
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
	
	
			
			
	
	
	public void Verify_InventoryModifier_Page() {
		try {
			if(StatusBar.isDisplayed()) {
				test.log(LogStatus.PASS, "Status bar is displayed in Inventory modifiers page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Status bar is not displayed in Inventory modifiers page");}
		
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
			if(LinkStatus_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Link Status Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Link Status Column is not displayed");}
		
		try {
			if(Actions_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Actions Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Actions Column is not displayed");}
		
	}
	
	public void VerifyTheLinkedInventoryModifier() throws Exception
	{
		Thread.sleep(2000);
		Search.clear();
		Search.sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));
		
		Thread.sleep(2000);
		if(linkedStatusForFirstRow.getText().trim().equals("Linked")) {
			test.log(LogStatus.PASS, "The mentioned modifier in the linked state");
			
			//Click the action button
			link_Unlink_Btn.click();
			
			Thread.sleep(3000);
			//get the value from the type drop down
			String tr = Select_Type.getAttribute("value");
			
			if(tr.equals("Sub Recipe")) {
				//Click the Cancel button
				Cancel_Btn.click();
			}
			else {
				Thread.sleep(1000);
				//Click the type drop down
				Select_Type.click();
				
				//Select the Option as Sub Recipe
				SubRecipe.click();
				
				Thread.sleep(10000);
				//Select the required sub recipe
				driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));

				//Click the Link Modifier button
				LinkModifierBtn.click();
				
				Thread.sleep(1500);
				// get the success message
				if (successMessage.getText().equals("Modifier updated successfully!.") ) {
					test.log(LogStatus.PASS, "Modifier updated successfully message is displayed when user click the Link Modifier button");
				}else {
					test.log(LogStatus.FAIL, "Modifier updated successfully message is not displayed when user click the Link Modifier button");
				}
			}
		}
		else
		{
			test.log(LogStatus.INFO, "The mentioned modifier is not linked with any item");
			
			//Click the action button
			link_Unlink_Btn.click();
			
			Thread.sleep(1000);
			//Click the type drop down
			Select_Type.click();
			
			//Select the Option as Sub Recipe
			SubRecipe.click();
			
			Thread.sleep(10000);
			//Select the required sub recipe
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));
			
			//Click the Link Modifier button
			LinkModifierBtn.click();
			
			Thread.sleep(1500);
			// get the success message
			if (successMessage.getText().equals("Modifier updated successfully!.") ) {
				test.log(LogStatus.PASS, "Modifier updated successfully message is displayed when user click the Link Modifier button");
			}else {
				test.log(LogStatus.FAIL, "Modifier updated successfully message is not displayed when user click the Link Modifier button");
			}
		}
	}
	
	
	public void getTheValueFromSubRecipe() throws Exception {
		//navigate to the sub recipe
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "subRecipe");
		
		Thread.sleep(8000);
		// Clear the search field
		Search.clear();

		// enter the inventory item
		Search.sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));
		Thread.sleep(4500);
		
		//click the edit button
		EditBtn.click();
		
		Thread.sleep(2000);
		recipeUnit = RecipeUnit.getAttribute("value");
		
		recipePrice = RecipePrice.getAttribute("value");
	}
	
	
	public void verifyInventoryMenuItem() throws Exception {
		//navigate to the inventory menu item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "menuItems");
		
		Thread.sleep(8000);
		// Clear the search field
		Search.clear();

		// enter the inventory item
		Search.sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));
		Thread.sleep(4500);
		
		//click the action button
		link_Unlink_Btn.click();
		
		Thread.sleep(2000);
		
		//Click the modifiers tab option
		ModifiersTab.click();
		Thread.sleep(1000);
		
		String recipeUnit1 = RecipeUnit1.getAttribute("value");
		
		String recipePrice1 = RecipePrice1.getText();
		
//		System.out.println("Receipt Unit is : "+recipeUnit);
//		System.out.println("Receipt Price is : "+recipePrice);
//		System.out.println("Receipt im Unit is : "+recipeUnit1);
//		System.out.println("Receipt im Price is : "+recipePrice1);
		
		if(recipeUnit.equalsIgnoreCase(recipeUnit1)) {
			test.log(LogStatus.PASS, "Receipt Unit is displayed correctly in Inventory Menu Item");
		}
		else {
			test.log(LogStatus.FAIL, "Receipt Unit is not displayed correctly in Inventory Menu Item");
			test.log(LogStatus.INFO, "Receipt Unit in Inveventory Modifier is : "+recipeUnit);
			test.log(LogStatus.INFO, "Receipt Unit in Inveventory Menu Item is : "+recipeUnit1);
		}
		
		if(recipePrice.equalsIgnoreCase(recipePrice1)) {
			test.log(LogStatus.PASS, "Receipt Price is displayed correctly in Inventory Menu Item");
		}
		else {
			test.log(LogStatus.FAIL, "Receipt Price is not displayed correctly in Inventory Menu Item");
			test.log(LogStatus.INFO, "Receipt Price in Inveventory Modifier is : "+recipePrice);
			test.log(LogStatus.INFO, "Receipt Price in Inveventory Menu Item is : "+recipePrice1);
		}
	}

	public void verifyProductAndItem_MenuItem() throws Exception {
		//navigate to the product and item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id1") + "productItems");
		
		Thread.sleep(8000);
		// Clear the search field
		Search.clear();

		// enter the inventory item
		Search.sendKeys(Utility.getProperty("Linked_Inventory_Modifier"));
		Thread.sleep(4500);
		
		//click the edit button
		EditBtn.click();
		
		Thread.sleep(25000);
		
		//Click the Inventory Details
		inventoryDetails.click();
		Thread.sleep(50000);
		
		//Click the modifiers tab option
		ModifiersTab.click();
		Thread.sleep(1000);
		
		String recipeUnit1 = RecipeUnit1.getAttribute("value");
		
		String recipePrice1 = RecipePrice1.getText();
		
//		System.out.println("Receipt Unit is : "+recipeUnit);
//		System.out.println("Receipt Price is : "+recipePrice);
//		System.out.println("Receipt PI Unit is : "+recipeUnit1);
//		System.out.println("Receipt PI Price is : "+recipePrice1);
		
		if(recipeUnit.equalsIgnoreCase(recipeUnit1)) {
			test.log(LogStatus.PASS, "Receipt Unit is displayed correctly in Inventory Menu Item");
		}
		else {
			test.log(LogStatus.FAIL, "Receipt Unit is not displayed correctly in Inventory Menu Item");
			test.log(LogStatus.INFO, "Receipt Unit in Inveventory Modifier is : "+recipeUnit);
			test.log(LogStatus.INFO, "Receipt Unit in Inveventory Menu Item is : "+recipeUnit1);
		}
		
		if(recipePrice.equalsIgnoreCase(recipePrice1)) {
			test.log(LogStatus.PASS, "Receipt Price is displayed correctly in Inventory Menu Item");
		}
		else {
			test.log(LogStatus.FAIL, "Receipt Price is not displayed correctly in Inventory Menu Item");
			test.log(LogStatus.INFO, "Receipt Price in Inveventory Modifier is : "+recipePrice);
			test.log(LogStatus.INFO, "Receipt Price in Inveventory Menu Item is : "+recipePrice1);
		}
		
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryModifiers");
		Thread.sleep(8000);
	}
	
	public void LinkTheUnlinkedModifiers() throws Exception {
		//Click the random page
		List<WebElement> pg = driver.findElements(By.xpath("//button[contains(@class,'mat-custom-page')]"));
	
		// create the random variable
		int rand = ThreadLocalRandom.current().nextInt(2, pg.size());
		
		//Click the random page
		driver.findElement(By.xpath("(//button[contains(@class,'mat-custom-page')])["+rand+"]")).click();
	
		//get the size of unlinked modifier from the page
		List<WebElement> unl = driver.findElements(By.xpath("//td[contains(.,'Not Linked')]/../td[3]"));
		
		if(unl.size() != 0) {
			
			//Click the unlinked item
			driver.findElement(By.xpath("//td[contains(.,'Not Linked')]/../td[3]")).click();
			Thread.sleep(3000);
			
			//click the select type button
			Select_Type.click();
			
			// get the number options from the list
			List<WebElement> lst = driver.findElements(By.xpath("//select-option"));

			// create the random variable
			int rands = ThreadLocalRandom.current().nextInt(2, lst.size());
			
			// get the value
			String statusOptions = driver.findElement(By.xpath("//div[" + rands +"]/select-option")).getText().trim();

			// Click the Random option from the list
			driver.findElement(By.xpath("//div[" + rands +"]/select-option")).click();
			
			
			if(statusOptions.equals("Not Inventory Item")) {
				//Click the Link Modifier button
				LinkModifierBtn.click();
			}
			else if(statusOptions.equals("Item")) {
				
				Thread.sleep(15000);
				
				//Click the category option
				driver.findElement(By.xpath("//label[contains(.,'Category')]/../../input")).click();
				
				// get the number options from the list
				List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

				// Save the count in variable
				int menuSize2 = menuList2.size();

				// create the random variable
				int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

				// Get the value
				String d = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

				// Enter the value in search box
				SearchBox_DropDown.sendKeys(d);
				Thread.sleep(1000);

				// Click the Random option from the list
				driver.findElement(By.xpath("//div[1]/select-option")).click();
			
				Thread.sleep(15000);
			
				//Click the category option
				driver.findElement(By.xpath("//label[contains(.,'Inventory Item')]/../../input")).click();
				
				// get the number options from the list
				List<WebElement> menuList21 = driver.findElements(By.xpath("//select-option"));

				// Save the count in variable
				int menuSize21 = menuList21.size();

				// create the random variable
				int randomMenu21 = ThreadLocalRandom.current().nextInt(1, menuSize21);

				// Get the value
				String d1 = driver.findElement(By.xpath("//div[" + randomMenu21 + "]/select-option")).getText();

				// Enter the value in search box
				SearchBox_DropDown.sendKeys(d1);
				Thread.sleep(1000);

				// Click the Random option from the list
				driver.findElement(By.xpath("//div[1]/select-option")).click();
			
			
				//Click the Link Modifier button
				LinkModifierBtn.click();
			
			}else if(statusOptions.equals("Sub Recipe")) {

				
				Thread.sleep(15000);
				
				//Click the category option
				driver.findElement(By.xpath("//label[contains(.,'Sub Recipe')]/../../input")).click();
				
				// get the number options from the list
				List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

				// Save the count in variable
				int menuSize2 = menuList2.size();

				// create the random variable
				int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

				// Get the value
				String d = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

				// Enter the value in search box
				SearchBox_DropDown.sendKeys(d);
				Thread.sleep(1000);

				// Click the Random option from the list
				driver.findElement(By.xpath("//div[1]/select-option")).click();
			
				Thread.sleep(4000);

				//Click the Link Modifier button
				LinkModifierBtn.click();
			}
			else if(statusOptions.equals("Modifier")) {
			Thread.sleep(15000);
				
				//Click the category option
				driver.findElement(By.xpath("//label[contains(.,'Menu Item')]/../../input")).click();
				
				// get the number options from the list
				List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

				// Save the count in variable
				int menuSize2 = menuList2.size();

				// create the random variable
				int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

				// Get the value
				String d = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

				// Enter the value in search box
				SearchBox_DropDown.sendKeys(d);
				Thread.sleep(1000);

				// Click the Random option from the list
				driver.findElement(By.xpath("//div[1]/select-option")).click();
			
				Thread.sleep(4000);

				//Click the Link Modifier button
				LinkModifierBtn.click();

			}
			
			Thread.sleep(1500);
			
			// get the success message
			if (successMessage.getText().equals("Modifier updated successfully!.") ) {
				test.log(LogStatus.PASS, "Modifier updated successfully message is displayed when user click the Link Modifier button");
			}else {
				test.log(LogStatus.FAIL, "Modifier updated successfully message is not displayed when user click the Link Modifier button");
			}
			
		}else if(unl.size()==0) {
			test.log(LogStatus.INFO, "In the given page, NOT LINKED ITEM is not available");
		}
	}
	
}