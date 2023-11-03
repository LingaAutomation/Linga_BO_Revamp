package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Inventory_Sub_Category_Page extends BasePage
{
	SelfHealingDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	ReportsPage rp;
	
	public String Cat1, SubCat;
	
	Utility ut=new Utility();
	
	public Inventory_Sub_Category_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath =  "//h3[contains(.,'New Sub-Category')]")
	WebElement NewSubCategoryTitle;
	
	@FindBy(xpath =  "//h3[contains(.,'Update Sub-Category')]")
	WebElement UpdateSubCategoryTitle;
	
	@FindBy(xpath =  "//button[contains(.,'NEW SUB-CATEGORY')]")
	WebElement NewSubCategoryBtn;
	
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
	
	@FindBy(xpath =  "//th[contains(.,'Category')]")
	WebElement Category_Column;
	
	@FindBy(xpath =  "//th[contains(.,'taxName')]")
	WebElement TaxName_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Description')]")
	WebElement description_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Value On Hand')]")
	WebElement ValueOnHand_Column;
	
	@FindBy(xpath =  "//th[contains(.,'Actions')]")
	WebElement Actions_Column;
	
	@FindBy(xpath =  "//button[contains(@class,'mat-custom-page')]")
	WebElement paginator;
	
	@FindBy(xpath =  "//label[contains(.,'Name')]/../../input")
	WebElement Name;
	
	@FindBy(xpath =  "//label[contains(.,'Category')]/../../input")
	WebElement Category;
	
	@FindBy(xpath =  "//label[contains(.,'Level')]/../../input")
	WebElement Level;
	
	@FindBy(xpath =  "//label[contains(.,'Code')]/../../input")
	WebElement Code;
	
	@FindBy(xpath =  "//app-toggle[@name='isTaxOverRide']/div/div/mat-button-toggle-group/mat-button-toggle[1]")
	WebElement OverrideTax_No;

	@FindBy(xpath =  "//app-toggle[@name='isTaxOverRide']/div/div/mat-button-toggle-group/mat-button-toggle[2]")
	WebElement OverrideTax_Yes;
	
	@FindBy(xpath =  "//label[contains(.,'Tax')]/../../input")
	WebElement Tax;
	
	@FindBy(xpath =  "//label[contains(.,'Description')]/../../textarea")
	WebElement description;
	
	@FindBy(xpath =  "//button[contains(.,'No') and @aria-pressed='true']")
	WebElement OverrideTax_Disabled;
	
	@FindBy(xpath =  "//button[contains(.,'Yes') and @aria-pressed='true']")
	WebElement OverrideTax_Enabled;
	
	@FindBy(xpath =  "//label[contains(.,'Sub Category')]/../../input")
	WebElement SubCategory;
	
	
	
	

	
	@FindBy(xpath = "//div[contains(@class,'inputs-rows delete-active')]/div/button")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement delete_Confirmation_Btn;
	


	@FindBy(xpath = "//button[contains(.,'Save') and @disabled='true']")
	WebElement Save_Btn_Disabled;
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement Save_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Update') and @disabled='true']")
	WebElement Update_Btn_Disabled;
	
	@FindBy(xpath = "//button[contains(.,'Update')]")
	WebElement Update_Btn;
	
	
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
	
	@FindBy(xpath =  "//button[contains(.,'NEW INVENTORY ITEM')]")
	WebElement NewInventoryItemBtn;
	
	@FindBy(xpath =  "//input/../div[contains(.,'Sub Category')]")
	WebElement SelectSubCategory;
	
	@FindBy(xpath =  "//button[contains(.,'NEW SUB RECIPE')]")
	WebElement NewSubRecipeBtn;
	
	@FindBy(xpath = "//span[contains(.,'Inventory Item')]/../../div[2]/div")
	WebElement AddInventoryItem;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[4]")
	WebElement LvlFld;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[5]")
	WebElement CategoryFld;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[6]")
	WebElement SubCategoryFld;
	
	
	
	
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
	
	@FindBy(xpath =  "//div[contains(@class,'justify-content-around text-primary')]/div[contains(.,'+ Add Inventory Item')]")
	WebElement addInvItem;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[1]")
	WebElement LVLFld_Menu;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[2]")
	WebElement CategoryFld_Menu;
	
	@FindBy(xpath = "(//div[contains(@class,'selectbox-component')]/mat-form-field)[3]")
	WebElement SubCategoryFld_Menu;
	

	
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
	
	
			
	public void Verify_SubCategory_Page() {
		try {
			if(NewSubCategoryBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "New Sub Category button is displayed in Sub Category page");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "New Sub Category button is not displayed in Sub Category page");}
		
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
			if(Category_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Category Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Category Column is not displayed");}
		
		try {
			if(TaxName_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Tax Name Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Tax Name Column is not displayed");}
		
		try {
			if(description_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Description Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Description Column is not displayed");}
		
		try {
			if(ValueOnHand_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Value on Hand Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Value on Hand Column is not displayed");}
				
		try {
			if(Actions_Column.isDisplayed()) {
				test.log(LogStatus.PASS, "Actions Column is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Actions Column is not displayed");}
		
	}
	
	public void VerifyTheNewSubCategoryPage() {
		//Click the New Sub Category button
		NewSubCategoryBtn.click();
		
		try {
			if(NewSubCategoryTitle.isDisplayed()) {
				test.log(LogStatus.PASS, "New Sub Category header is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "New Sub Category header is not displayed");}
		
		try {
			if(Name.isDisplayed()) {
				test.log(LogStatus.PASS, "Name field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Name field is not displayed");}
		
		try {
			if(Category.isDisplayed()) {
				test.log(LogStatus.PASS, "Category field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Category field is not displayed");}
		
		try {
			if(Code.isDisplayed()) {
				test.log(LogStatus.PASS, "Code field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Code field is not displayed");}
		
		try {
			if(OverrideTax_No.isDisplayed()) {
				test.log(LogStatus.PASS, "Override No toggle is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Override No toggle is not displayed");}
		
		try {
			if(OverrideTax_Yes.isDisplayed()) {
				test.log(LogStatus.PASS, "Override Yes toggle is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Override Yes toggle is not displayed");}
		
		try {
			if(Tax.isDisplayed()) {
				test.log(LogStatus.PASS, "Tax field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Tax field is not displayed");}
		
		try {
			if(description.isDisplayed()) {
				test.log(LogStatus.PASS, "Description field is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Description field is not displayed");}
		
		try {
			if(Save_Btn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button field is disabled");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Save button field is Enabled");}
		

	}
	
	public void enterTheName(String SubCatName) {
		Name.sendKeys(SubCatName);
	}
	
	
	
	public String select_Category(String Cate) throws Exception {
		//System.out.println("cat is : "+Cate);
		// Click the Category input field
		Category.click();
		Thread.sleep(2500);

		// get the number options from the list
		List<WebElement> menuList2 = driver.findElements(By.xpath("//select-option"));

		// Save the count in variable
		int menuSize2 = menuList2.size();

		// create the random variable
		int randomMenu2 = ThreadLocalRandom.current().nextInt(1, menuSize2);

		// Get the value
		String vendora = driver.findElement(By.xpath("//div[" + randomMenu2 + "]/select-option")).getText();

		Cate = Cat1 = vendora;
		
		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(vendora);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		System.out.println("category is : "+Cate);
		//System.out.println("categorywwwwwwwwwwwwww is : "+Cat1);
		return Cate;
	}
	
	public void EnterTheCode() {
		//Clear the code
		Code.clear();
		
		//enter the code
		Code.sendKeys(RandomStringUtils.randomAlphanumeric(8));
	}
	
	public void enableTheOverrideTax() {
		//Click the Yes button
		OverrideTax_Yes.click();
	}
	
	public void disableTheOverrideTax() {
		//Click the No button
		OverrideTax_No.click();
	}
	
	public void select_Tax() throws Exception {

		// Click the Tax input field
		Tax.click();
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
	
	public void EnterTheDescription() {
		//clear the description
		description.clear();
		
		//enter the description
		description.sendKeys("Sub Category's Description");
	}
	

	public void SearchTheSubCategory(String search) {
		Search.clear();
		Search.sendKeys(search);
	}
	
	public void clickEditButton() throws Exception {
		Thread.sleep(1500);
		
		//Click the edit button
		EditBtn.click();
		
		Thread.sleep(1500);
		try {
			if(UpdateSubCategoryTitle.isDisplayed()) {
				test.log(LogStatus.PASS, "Update Sub Category header is displayed");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Update Sub Category header is not displayed");}	
		
		try {
			if(Update_Btn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Update button disabled when user not change anything");
			}
		}catch(Exception e) {test.log(LogStatus.FAIL, "Update button enabled when user not change anything");}	
	}

	public void saveTheSubCategory() throws Exception {
		//Click the Save button
		Save_Btn.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Sub Category saved successfully!.")) {
			test.log(LogStatus.PASS,"Sub Category saved successfully!. popup displayed after click the Save button");
		} else {
			test.log(LogStatus.FAIL,"Sub Category saved successfully!. popup is not displayed after click the Save button");
		}
	}
	
	public void editTheSubCategory() throws Exception {
		
		try {
			if(OverrideTax_Enabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Override Tax toggle is enabled while user click the edit button of Sub Category. User enable the Override Tax while create the Sub Category");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Override Tax toggle is disabled while user click the edit button of Sub Category. User enable the Override Tax while create the Sub Category");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//disable the Override Tax
		disableTheOverrideTax();
		
		//change the code
		Code.sendKeys("1");
		
		Thread.sleep(1500);
		//Click the update button
		Update_Btn.click();
		
		Thread.sleep(1500);
		// get the success message
		if (successMessage.getText().equals("Sub Category updated successfully!.")) {
			test.log(LogStatus.PASS,"Sub Category updated successfully!. popup displayed after click the Update button");
		} else {
			test.log(LogStatus.FAIL,"Sub Category updated successfully!. popup is not displayed after click the Update button");
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
		if (successMessage.getText().equalsIgnoreCase("Sub Category InActivated Successfully!.")) {
			test.log(LogStatus.PASS,"Sub Category InActivated Successfully!. popup displayed after confirm the delete option");
		} else {
			test.log(LogStatus.FAIL,"Sub Category InActivated Successfully!. popup is not displayed after confirm the delete option");
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
			test.log(LogStatus.PASS, "The required Sub Category is availble in the InActive page");
		}else {
			test.log(LogStatus.FAIL, "The required Sub Category is not availble in the InActive page");
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
		if (successMessage.getText().equalsIgnoreCase("Sub Category activated Successfully!.")) {
			test.log(LogStatus.PASS,"Sub Category activated Successfully!. popup displayed after confirm the activate option");
		} else {
			test.log(LogStatus.FAIL,"Sub Category activated Successfully!. popup is not displayed after confirm the activate option");
		}
		
	}
	
	public void verifyTheTemplateAvailabilityInActiveStatus(String na) throws Exception {
		Thread.sleep(2000);
		//verify the availability
		if(driver.findElement(By.xpath("//td/span[contains(.,'"+na+"')]")).isDisplayed()) {
			test.log(LogStatus.PASS, "The required Sub Category is availble in the Active page");
		}else {
			test.log(LogStatus.FAIL, "The required Sub Category is not availble in the Active page");
		}
	}
	public void inActiveBtn() throws Exception {
		//Click the activate button
		InactiveBtn.click();
		Thread.sleep(1000);
	}
	
	public String verifyInTheInventoryItem(String subc, String Cate) throws Exception {
		//Inventory item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryItem");

		Thread.sleep(5000);
		
		//Click the New Inventory Item button
		NewInventoryItemBtn.click();
		
		Thread.sleep(1000);
		
		//Select the sub category option
		SelectSubCategory.click();
		
		//Click the CAtegory option
		Category.click();
		//System.out.println("Catttttttt is : "+Cate);
		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(Cate);
		Thread.sleep(1000);

		// Click the Random option from the list
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		Thread.sleep(1000);
		
		verifyTheSubCategory(subc);
		return Cate;
	}
	
	public void verifyTheSubCategory(String sub) throws Exception {
		//Click the Sub Category
		SubCategory.click();
		
		// Enter the value in search box
		driver.findElement(By.xpath("//div[@class='option-list']//input[@data-placeholder='Search']")).sendKeys(sub);
		Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//div[1]/select-option")).getText().trim().equalsIgnoreCase(sub)) {
			test.log(LogStatus.PASS, "The required sub category is reflected in the Inventory Items page");
		}else {
			test.log(LogStatus.FAIL, "The required sub category is not reflected in the Inventory Items page");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public String verifyInTheSubRecipr(String subc,String Cate) throws Exception {
		//Inventory item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "subRecipe");

		Thread.sleep(5000);
		
		//Click the New Sub Recipe button
		NewSubRecipeBtn.click();
		
		Thread.sleep(1000);
		
		//Click the Add Inventory Item
		AddInventoryItem.click();
		
		Thread.sleep(1000);
		//Select the sub category option
		LvlFld.click();
		
		Thread.sleep(500);
		//Click the Sub Category Option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Sub Category')]")).click();
		
		
		Thread.sleep(1000);
		
		try {
			//Click the category field
			CategoryFld.click();
			
			//select the required category
			driver.findElement(By.xpath("//select-option/div[contains(.,'"+Cate+"')]")).click();
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Unable to Select the required Category in the Sub Recipe page and the Category is : "+Cate);
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		try {
			//Click the sub category field
			SubCategoryFld.click();
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//select-option")).isDisplayed()) {
				//select the required sub category
				driver.findElement(By.xpath("//select-option/div[contains(.,'"+subc+"')]")).click();
			}
			
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("(//div[contains(@class,'selectbox-component')]/mat-form-field)[6]/div/div/div[3]/input")).getAttribute("value").trim().equalsIgnoreCase(subc)) {
				test.log(LogStatus.PASS, "The required sub category is reflected in the Sub Recipe page");
			}else {
				test.log(LogStatus.FAIL, "The required sub category is not reflected in the Sub Recipe page");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Unable to Select the required Sub Category in the Sub Recipe page");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		return Cate;
		
	}
	
	public String verifyProductAndItem_MenuItem(String subc,String Cate) throws Exception {
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
		Thread.sleep(25000);
		
		//Click the add inventory item
		addInvItem.click();
		Thread.sleep(1000);
		//Select the sub category option
		LVLFld_Menu.click();
		
		Thread.sleep(500);
		//Click the Sub Category Option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Sub Category')]")).click();
		Thread.sleep(1000);
		
		try {
			//Click the category field
			CategoryFld_Menu.click();Thread.sleep(3000);
			
			//select the required category
			driver.findElement(By.xpath("//select-option/div[contains(.,'"+Cate+"')]")).click();Thread.sleep(1000);
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Unable to Select the required Category in the Menu Item page and the Category is : "+Cate);
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		try {
			//Click the sub category field
			SubCategoryFld_Menu.click();Thread.sleep(1000);
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//select-option")).isDisplayed()) {
				//select the required sub category
				driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+subc+"')]")).click();
			}
			
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("(//div[contains(@class,'selectbox-component')]/mat-form-field)[3]/div/div/div[3]/input")).getAttribute("value").trim().equalsIgnoreCase(subc)) {
				test.log(LogStatus.PASS, "The required sub category is reflected in the Menu Item page");
			}else {
				test.log(LogStatus.FAIL, "The required sub category is not reflected in the Menu Item page");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Unable to Select the required Sub Category in the Menu Item page");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Thread.sleep(5000);
		//navigate to the product and item
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id1") + "productItems");
		
		Thread.sleep(8000);
		//Click the retail tab
		driver.findElement(By.xpath("//button[contains(.,'RETAIL ITEMS')]")).click();
		
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
		Thread.sleep(25000);

		//Click the level
		Level.click();
		
		//Select the sub category
		driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'Sub Category')]")).click();
		

		
	Thread.sleep(1000);
		
		try {
			//Click the category
			Category.click();Thread.sleep(3000);
			
			//select the required category
			driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+Cate+"')]")).click();Thread.sleep(1000);
		}catch(Exception s) {
			//Click the category
			Category.click();
			test.log(LogStatus.FAIL, "Unable to Select the required Category in the Retail Item page and the Category is : "+Cate);
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		try {
			//Click the sub category field
			SubCategory.click();Thread.sleep(1000);
			
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//select-option")).isDisplayed()) {
				//select the required sub category
				driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+subc+"')]")).click();
			}
			
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("//label[contains(.,'Sub Category')]/../../input")).getAttribute("value").trim().equalsIgnoreCase(subc)) {
				test.log(LogStatus.PASS, "The required sub category is reflected in the Retail Item page");
			}else {
				test.log(LogStatus.FAIL, "The required sub category is not reflected in the Retail Item page");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Unable to Select the required Sub Category in the Retail Item page");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "inventoryModifiers");
		Thread.sleep(8000);
		return Cate;
	}
	
}