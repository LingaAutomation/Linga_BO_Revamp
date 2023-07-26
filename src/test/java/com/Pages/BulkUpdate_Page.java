package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class BulkUpdate_Page {

	 public WebDriver driver;
	    public ExtentTest test;
	   
	    Utility ut=new Utility();
	    public  BulkUpdate_Page(WebDriver driver, ExtentTest test) 
	    {
	    	this.driver=driver;
	    	this.test=test;
	    	
	    	PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath = "//span[contains(.,'UPDATE ITEM PRICE')]")
	    WebElement UPDATE_ITEM_PRICE;
	  
	  
	    
	    @FindBy(xpath = "//table/tbody/tr[1]/td[6]//input")
	    WebElement TextInput;
	    
	    
	    
	    @FindBy(xpath = "//table/tbody/tr[1]/td[5]//span")
	    WebElement Existing_Price;
	    
	  
	    
	    @FindBy(xpath = "//table/tbody/tr[1]/td[7]")
	    WebElement Change_Price;
	    
	 
	    
	    @FindBy(xpath = "//table/tbody/tr[1]/td[2]/span")
	    WebElement Menu_Name;
	    
	    
	    		
	    @FindBy(xpath = "//input[@placeholder='Search']")
	    WebElement SearchBox_BulkUpdate;
	    
	  
	    
	    @FindBy(xpath = "//span[contains(.,' BULK CHANGE ')]")
	    WebElement BULK_CHANGE_Button;
	    
	  
	    
	    @FindBy(xpath = "//th[contains(.,'Category/Sub-Category')]/../th[1]/mat-checkbox")
	    WebElement Check_Box_Bulk_Update;
	    
	  
	    
	    @FindBy(xpath = "//span[contains(.,' BULK CHANGE ')]")
	    WebElement Bulk_Change_button;
	    
	  
	    
	    @FindBy(xpath = "//h3[contains(.,'Bulk Change')]")
	    WebElement Bulk_Change_Header;
	  
	    
	    @FindBy(xpath = "//span[contains(@class,'closeBtn')]")
	    WebElement Close_button;
	    
	    @FindBy(xpath = "//app-toggle[@name='operationType']//mat-button-toggle-group/mat-button-toggle/button[contains(.,'Decrease')]")
	    WebElement Decrease_button;
	    
	    
	    @FindBy(xpath = "//app-toggle[@name='operationType']//mat-button-toggle-group/mat-button-toggle/button[contains(.,'Increase')]")
	    WebElement Increase_button;
	    
	  
	    
	    @FindBy(xpath = "//app-toggle[@name='changeBy']//mat-button-toggle-group/mat-button-toggle/button[contains(.,'Amount')]")
	    WebElement Amount_button;
	    
	    @FindBy(xpath = "//app-toggle[@name='changeBy']//mat-button-toggle-group/mat-button-toggle/button[contains(.,'Percentage')]")
	    WebElement Percentage_button;
	    
	    @FindBy(xpath = "//label[contains(.,' Amount ')]/../../input")
	    WebElement Amount_input;
	 
	    @FindBy(xpath = " //label[contains(.,' Percentage ')]/../../input")
	    WebElement Percentage_input;
	    
	    @FindBy(xpath = "//button[contains(.,'change')]")
	    WebElement Change_button;
	    
	    @FindBy(xpath = "//button[contains(.,'Cancel')]")
	    WebElement Cancel_button;
	    
	    
		@FindBy(xpath = "//h3[@class='title']")
		WebElement MainScreenHeader;
		
		//select Decrease 
		public void select_Decrease() {
			Decrease_button.click();
		}
		//select Increase 
		public void select_Increase() {
			Increase_button.click();
		}
		//select amount
		public void select_Amount() {
			Amount_button.click();
		}
		//select percentage
		
		public void select_percentage() {
			Percentage_button.click();
		}
		
		//decrease by amount 
		public void decrease_by_amount () throws InterruptedException {
			
String item_Name = Menu_Name.getText();
			
			new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
			
			String Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			
			test.log(LogStatus.INFO, "Existing_Menu_Price : "+Existing_Menu_Price);
		
			double Existing_Menu=Double.parseDouble(Existing_Menu_Price);
			
			

			Thread.sleep(3000);
			new Common_XPaths(driver, test).SearchBox.clear();
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			Check_Box_Bulk_Update.click();
			
			Thread.sleep(3000);
			Bulk_Change_button.click();
			//verify header while  cancel and close Bulk_Change
			Thread.sleep(3000);
			if(Bulk_Change_Header.getText().equals("Bulk Change"))
			{
				test.log(LogStatus.PASS, " Creation page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL," Creation Page Loaded Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			select_Decrease();
			Thread.sleep(3000);
			select_Amount();
			Amount_input.sendKeys("200");
			Thread.sleep(3000);
			Change_button.click();
			Thread.sleep(3000);
			
			
			
			String bulk_amount = "2.00" ;
			
			double bulk_Amount=Double.parseDouble(bulk_amount);
			
		String Change_Menu_Price = Change_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			
			test.log(LogStatus.INFO, "Change_Menu_Price : "+Change_Menu_Price);
			
			
			 double Change_value = Existing_Menu - bulk_Amount ;
			 
			 test.log(LogStatus.INFO, "Menu item Change_value  : "+Change_value);
			
			UPDATE_ITEM_PRICE.click();
			

			
		}
		
		//decrease by percentage 
		
		public void decrease_by_percentage () throws InterruptedException {
			
			String item_Name = Menu_Name.getText();
						
						new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
						
						String Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Existing_Menu_Price : "+Existing_Menu_Price);
					
						double Existing_Menu=Double.parseDouble(Existing_Menu_Price);
						
						

						Thread.sleep(3000);
						new Common_XPaths(driver, test).SearchBox.clear();
						Thread.sleep(6000);
						driver.navigate().refresh();
						Thread.sleep(3000);
						Check_Box_Bulk_Update.click();
						
						Thread.sleep(3000);
						Bulk_Change_button.click();
						//verify header while  cancel and close Bulk_Change
						Thread.sleep(3000);
						if(Bulk_Change_Header.getText().equals("Bulk Change"))
						{
							test.log(LogStatus.PASS, " Creation page Loaded Successfully");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL," Creation Page Loaded Failed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						select_Decrease();
						Thread.sleep(3000);
						select_percentage();
						Percentage_input.sendKeys("10000");
						Thread.sleep(3000);
						String percent = Percentage_input.getAttribute("value");
						
						Change_button.click();
						Thread.sleep(3000);
						
						
						
						String bulk_amount = percent.replaceAll("[a-zA-Z $ ₹ , % :]", "").substring(1).toString() ;
						
						String bulk_percentage = bulk_amount;
						double Bulk_percentage=Double.parseDouble(bulk_percentage);
						
					String Change_Menu_Price = Change_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Change_Menu_Price : "+Change_Menu_Price);
						
						
						 double Change_value = Existing_Menu / Bulk_percentage ;
						 
						 test.log(LogStatus.INFO, "Menu item Change_value  : "+Change_value);
						
						UPDATE_ITEM_PRICE.click();
						

						
					}
		//increase by amount
		
		public void Increase_by_amount () throws InterruptedException {
			
			String item_Name = Menu_Name.getText();
						
						new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
						
						String Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Existing_Menu_Price : "+Existing_Menu_Price);
					
						double Existing_Menu=Double.parseDouble(Existing_Menu_Price);
						
						

						Thread.sleep(3000);
						new Common_XPaths(driver, test).SearchBox.clear();
						Thread.sleep(6000);
						driver.navigate().refresh();
						Thread.sleep(3000);
						Check_Box_Bulk_Update.click();
						
						Thread.sleep(3000);
						Bulk_Change_button.click();
						//verify header while  cancel and close Bulk_Change
						Thread.sleep(3000);
						if(Bulk_Change_Header.getText().equals("Bulk Change"))
						{
							test.log(LogStatus.PASS, " Creation page Loaded Successfully");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL," Creation Page Loaded Failed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						select_Increase();
						Thread.sleep(3000);
						select_Amount();
						Amount_input.sendKeys("200");
						Thread.sleep(3000);
						Change_button.click();
						Thread.sleep(3000);
						
						
						
						String bulk_amount = "2.00" ;
						
						double bulk_Amount=Double.parseDouble(bulk_amount);
						
					String Change_Menu_Price = Change_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Change_Menu_Price : "+Change_Menu_Price);
						
						
						 double Change_value = Existing_Menu + bulk_Amount ;
						 
						 test.log(LogStatus.INFO, "Menu item Change_value  : "+Change_value);
						
						UPDATE_ITEM_PRICE.click();
						

						
					}
		
		
		//decrease by percentage 
		
		public void Increase_by_percentage () throws InterruptedException {
			
			String item_Name = Menu_Name.getText();
						
						new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
						
						String Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Existing_Menu_Price : "+Existing_Menu_Price);
					
						double Existing_Menu=Double.parseDouble(Existing_Menu_Price);
						
						

						Thread.sleep(3000);
						new Common_XPaths(driver, test).SearchBox.clear();
						Thread.sleep(6000);
						driver.navigate().refresh();
						Thread.sleep(3000);
						Check_Box_Bulk_Update.click();
						
						Thread.sleep(3000);
						Bulk_Change_button.click();
						//verify header while  cancel and close Bulk_Change
						Thread.sleep(3000);
						if(Bulk_Change_Header.getText().equals("Bulk Change"))
						{
							test.log(LogStatus.PASS, " Creation page Loaded Successfully");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL," Creation Page Loaded Failed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						select_Increase();
						Thread.sleep(3000);
						select_percentage();
						Percentage_input.sendKeys("10000");
						Thread.sleep(3000);
						String percent = Percentage_input.getAttribute("value");
						
						Change_button.click();
						Thread.sleep(3000);
						
						
						
						String bulk_amount = percent.replaceAll("[a-zA-Z $ ₹ , % :]", "").substring(1).toString() ;
						
						String bulk_percentage = bulk_amount;
						double Bulk_percentage=Double.parseDouble(bulk_percentage);
						
					String Change_Menu_Price = Change_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
						
						test.log(LogStatus.INFO, "Change_Menu_Price : "+Change_Menu_Price);
						
						
						 double Change_value = Existing_Menu / Bulk_percentage ;
						 
						 
						 
						 test.log(LogStatus.INFO, "Menu item Change_value  : "+Change_value);
						
						UPDATE_ITEM_PRICE.click();
						

						
					}
		public void VerifyMainScreenPageHeader(String Str)
		{
			if(MainScreenHeader.getText().equals(Str))
			{
				test.log(LogStatus.PASS, Str+" Page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, Str+" Page Loaded Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		

		public void VerifyCreationScreenPageHeader(String Str)
		{
			if(Bulk_Change_Header.getText().equals(Str))
			{
				test.log(LogStatus.PASS, Str+" Creation page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, Str+" Creation Page Loaded Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		public void Increase_single_Menu_Item() throws Exception
		{
		
			String item_Name = Menu_Name.getText();
			
//			new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
			new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
			
			String Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			
			test.log(LogStatus.INFO, "Existing_Menu_Price : "+Existing_Menu_Price);
		
			double Existing_Menu=Double.parseDouble(Existing_Menu_Price);
			
			
			TextInput.sendKeys(Utility.getProperty("Bulk_Update_Amount"));
			
			String bulk_amount = Utility.getProperty("Bulk_Update_Amount") ;
			
			double bulk_Amount=Double.parseDouble(bulk_amount);
			
		String Change_Menu_Price = Change_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			
			test.log(LogStatus.INFO, "Change_Menu_Price : "+Change_Menu_Price);
			
			
			 double Change_value = bulk_Amount - Existing_Menu;
			 
			 test.log(LogStatus.INFO, "Menu item Change_value  : "+Change_value);
			
			UPDATE_ITEM_PRICE.click();
			
	String After_change_Existing_Menu_Price = Existing_Price.getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			
			test.log(LogStatus.INFO, "After_change_Existing_Menu_Price : "+After_change_Existing_Menu_Price);
		
			double after_change_Existing_Menu_Price=Double.parseDouble(After_change_Existing_Menu_Price);
			
			if(Existing_Menu<=after_change_Existing_Menu_Price) {
				
				double diff = after_change_Existing_Menu_Price-Existing_Menu;
				
				test.log(LogStatus.PASS, "After update Exiting Menu item Price Change Sucessfully "+diff);
					
			}
			else {
				test.log(LogStatus.FAIL, "After update Exiting Menu item Price  not change ");	
			}
			
			Thread.sleep(3000);
			new Common_XPaths(driver, test).SearchBox.clear();
			Thread.sleep(6000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			
			//Load the bulk Menu Updates page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");
			Thread.sleep(6000);
			new Common_XPaths(driver, test).SearchBox.sendKeys(item_Name);
			
			String item_price = driver.findElement(By.xpath("//td[contains(.,'"+item_Name+"')]/../td[5]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").substring(1).toString();
			Thread.sleep(6000);
			
			if(After_change_Existing_Menu_Price.equalsIgnoreCase(item_price)) {
				System.out.println("pass");
			}
			else {
				System.out.println("Fail");
				
			}
		}
		
		public void Bulk_update_menu_Item() throws Exception
		{
			
			List<WebElement> menuname = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[3]/span"));
			
			int menu = menuname.size();
			
			Thread.sleep(5000);
			//Load the bulk Menu Updates page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"bulkMenuUpdate");

			Thread.sleep(5000);
	
			
			Check_Box_Bulk_Update.click();
			Thread.sleep(3000);
			Bulk_Change_button.click();
			//verify header while  cancel and close Bulk_Change
		
			if(Bulk_Change_Header.getText().equals("Bulk Change"))
			{
				test.log(LogStatus.PASS, " Creation page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL," Creation Page Loaded Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Close_button.click();
			Thread.sleep(3000);
			Bulk_Change_button.click();
			//verify header while  cancel and close Bulk_Change
		
			if(Bulk_Change_Header.getText().equals("Bulk Change"))
			{
				test.log(LogStatus.PASS, " Creation page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL," Creation Page Loaded Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Cancel_button.click();
			Thread.sleep(3000);
			
			
			
			
			
			
			
			
		}
		
		public void Bulk_update () throws Exception {
			Common_XPaths cmp=new Common_XPaths(driver, test);
			ArrayList<String> menuList=new ArrayList<String>();
			ArrayList<String> priceList=new ArrayList<String>();
			
			String s1 = null;
			String s2 = null;
			String s3 = null;
			String s4 = null;
		
			String u1 = null;
			String u2 = null;
			String u3 = null;
			String u4 = null;
			
			
	
	//		String s=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[3]/span")).getText();
		
	
		
		
		
			List<WebElement> menuname = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[3]/span"));
			int size = menuname.size();
			for (WebElement webElement : menuname) {
	            String Menuname = webElement.getText();
	            System.out.println(Menuname);
	            menuList.add(Menuname);
			}
			
			for(int i=1;i<=size;i++) {
				Thread.sleep(3000);
          driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]//input")).sendKeys("3000");
          Thread.sleep(3000);
			}
			
			UPDATE_ITEM_PRICE.click();
			
			List<WebElement> menuname_price = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[5]/div/span"));
			for (WebElement webElement : menuname_price) {
	            String Menuname_price = webElement.getText();
	            System.out.println(Menuname_price);
	            priceList.add(Menuname_price);
			}
			
			
			//Load the bulk Menu Updates page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");
			Thread.sleep(6000);
			
	
			for(int i=0;i<4;i++)
			{
			
			try {
				cmp.Verify_Search(menuList.get(i));
			if(driver.findElement(By.xpath("//div[contains(.,'"+menuList.get(i)+"')]/../div/div[5]/div/div/span[contains(.,'"+priceList.get(i)+"')]")).isDisplayed())
				
			{
				test.log(LogStatus.PASS, menuList.get(i)+" Price Updated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, menuList.get(i)+"Price is not Updated");
			}
			}
			
			catch (Exception e) {
				// TODO: handle exception
				test.log(LogStatus.FAIL, menuList.get(i)+"Menu are not avilable in product and item ");
			}
		}
		
		
	    
}
}