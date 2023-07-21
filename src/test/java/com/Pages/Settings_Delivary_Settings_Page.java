package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Delivary_Settings_Page {
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public Settings_Delivary_Settings_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//span[contains(.,'Delivery')]")
	WebElement Delivary;
	
	@FindBy(xpath = "(//div[contains(@class,'d-flex justify-content-end')])[1]/button/span[1]")
	WebElement sync;
	
	@FindBy(xpath = "//app-input[@type='currency']/div/div/mat-form-field/div/div[1]/div[4]/input")
	WebElement cost;
	
	@FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix')])[3]/input")
	WebElement per;
	
	@FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix')])[4]/input")
	WebElement min;
	
	@FindBy(xpath = "(//div[contains(@class,'mobile-tool-box')])[2]/button")
	WebElement action_btn;
	
	@FindBy(xpath = "(//div[contains(@class,'align-items-center')])[1]/button")
	WebElement add_zone;
	
	@FindBy(xpath = "//app-toggle[contains(@class,'ng-untouched')]/div/mat-button-toggle-group/mat-button-toggle/button")
	WebElement puc_tog;
	
	@FindBy(xpath = "//button/span/span[.='DELIVERY ZONES']")
	WebElement delzone_btn;
	
	@FindBy(xpath = "//button/span/span[.='PUC']")
	WebElement puc_btn;
	
	@FindBy(xpath = "//button/span/span[.='DRIVER']")
	WebElement driver_btn;
	
	@FindBy(xpath = "((//div[contains(@class,'col-sm-')])[4]/app-segmentation/div/div/button)[4]")
	WebElement driver_dept;
	
	@FindBy(xpath = "//div[contains(@class,'drawer-footer')]/div[2]/button")
	WebElement save;
	
	@FindBy(xpath = "(//div[@class='toggle-component-group']/mat-button-toggle-group/mat-button-toggle/button)[2]")
	WebElement puc_Yes;
	
	@FindBy(xpath = "//div[contains(@class,'app-container')]/div[1]/div[3]/div/div[3]/button")
	WebElement save_btn;
	
	@FindBy(xpath = "//app-input[@type='text']/div/div/mat-form-field/div/div[1]/div[4]/input")
	WebElement zone_name;
	
	@FindBy(xpath = "(//app-input[@size='normal'])[1]/div/div/mat-form-field/div/div[1]/div[4]/input")
	WebElement zone_time;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dialog-component')]/div[3]/div/div[2]")
	WebElement delete_btn;
	
	@FindBy(xpath = "(//button[contains(@class,'action-button')])[2]/span[1]")
	WebElement edit_btn;
	
	@FindBy(xpath = "//div[contains(@class,'drawer-footer')]/div[2]/button/span[1]")
	WebElement updt_btn;
	
	@FindBy(xpath = "//div[contains(@class,'message')]/span")
	WebElement AlertMessageTitle;
	
	public void Click_Edit_zone() throws Exception {
		Thread.sleep(2000);
		edit_btn.click();
		Thread.sleep(2000);
		zone_name.clear();
		Thread.sleep(2000);
		zone_name.sendKeys(Utility.getProperty("New_Store_State")+"1");
		Thread.sleep(2000);
		
		//up-down arrow
				List<WebElement> tm=driver.findElements(By.xpath("//div[contains(@class,'drawer-container')]/app-new-delivery-zone/div/div[2]/div/div/app-input/div/div/div/button/span[1]/mat-icon"));
				for(WebElement t:tm) {
					t.click();
					Thread.sleep(1000);
				}
				Thread.sleep(1000);
		
		updt_btn.click();
		Thread.sleep(2000);
	}
	
	public void Click_Active() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'active-toggle')]/span[1]")).click();
		Thread.sleep(5000);
	}
	
	public void search_zone() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-placeholder='Search']")).sendKeys(Utility.getProperty("New_Store_State"));
		Thread.sleep(5000);
	}
	
	public void Click_Inctive() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list-')]/div[1]/data-grid-row/div/div[4]/button/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'action-buttons')]/div/div[2]/button/span[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'top-actions')]/div/div[1]/button/span[1]")).click();
		Thread.sleep(5000);
	}
	
	public void Click_Delete() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/data-grid-row/div/div[4]/button[2]")).click();
		Thread.sleep(2000);
	}
	
	public void Click_save() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'header-sticky')]/div[3]/div/div[3]/button/span[2]")).click();
		Thread.sleep(2000);
	}
	
	public void Click_alert_Delete() {
		delete_btn.click();
	}
	
	public void Click_store() throws InterruptedException {
		driver.findElement(By.xpath("(//div[contains(@class,'menu-item-title')])[2]/span")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@data-placeholder='Search']")).sendKeys("PART4");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@class,'row ')])[9]/div[1]")).click();
		Thread.sleep(5000);
	}
	
	public void Click_Delivery() {
		Delivary.click();
	}
	
	public void Click_Save() {
		save_btn.click();
	} 
	
	public void Delivery_new() throws InterruptedException {
		Thread.sleep(2000);
		edit_btn.click();
		Thread.sleep(2000);
		zone_name.clear();
		Thread.sleep(2000);
		cost.clear();
		Thread.sleep(2000);
		zone_time.clear();
		Thread.sleep(2000);
		updt_btn.click();
		Thread.sleep(5000);

		
		/*String Str= "Account Balance Updated Successfully";
		if(AlertMessageTitle.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+"Account Balance Updated Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+"Account Balance Updated Successfully");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);*/
	}
	
	public void Click_Setting_Delivery() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		sync.click();
		driver.findElement(By.xpath("(//div[contains(@class,'action-buttons')])[1]/div/div[1]/button")).click();
		Thread.sleep(5000);
		sync.click();
		driver.findElement(By.xpath("(//div[contains(@class,'action-buttons')])[1]/div/div[2]/button")).click();
		Thread.sleep(5000);
		
		cost.clear();Thread.sleep(500);
		cost.sendKeys(Utility.getProperty("cost"));
		Thread.sleep(1000);
		save_btn.click(); 
		String str1=cost.getAttribute("value");//string store
		Thread.sleep(500);
		cost.sendKeys(Utility.getProperty("value1"));//string2 store
		Thread.sleep(1000);
		save_btn.click(); 
		String str2=cost.getAttribute("value");
		//compare 
		Thread.sleep(1000);
		if(str1.equals(str2))
		{
			test.log(LogStatus.PASS,str2+"Cost accept valid numerical value");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, str2+"Cost not accept other than numerical value");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		per.clear();
		//per.sendKeys(Utility.getProperty("percentage"));
		Thread.sleep(500);
		save_btn.click();
		Thread.sleep(5000);
		String st1=per.getAttribute("value");//string store
		Thread.sleep(5000);
		per.sendKeys(Utility.getProperty("value1"));
		Thread.sleep(1500);
		save_btn.click(); 
		String st2=cost.getAttribute("value");
		//compare 
		Thread.sleep(1000);
		if(st1.equals(st2))
		{
			test.log(LogStatus.PASS,st2+"Entered Percentage is valid format, it accept numericals only");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL,st2 + "Entered Percentage in invalid format");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement up1=driver.findElement(By.xpath("//app-input[contains(@type,'percentage')]/div/div/div/button[1]/span[1]/mat-icon"));
		up1.click();
		String st4=cost.getAttribute("value");
		if(st1!=st4)
		{
			test.log(LogStatus.PASS,st4 +"Entered percentage increased by 1");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, st4 +"Entered percentage not increased by 1");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		WebElement dn1=driver.findElement(By.xpath("//app-input[contains(@type,'percentage')]/div/div/div/button[2]/span[1]/mat-icon"));
		dn1.click();
		String st5=cost.getAttribute("value");
		if(st4!=st5)
		{
			test.log(LogStatus.PASS,st5 +"Entered percentage decreased by 1");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL,st5 +"Entered percentage not decreased by 1");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		min.clear();
		min.sendKeys(Utility.getProperty("minute1"));
		Thread.sleep(500);
		String msg1=driver.findElement(By.xpath("//div[contains(@class,'tab-content')]/div[4]/div[2]/div[2]")).getText();
		save_btn.click();
		Thread.sleep(5000);
		String str3=per.getAttribute("value");//string store
		Thread.sleep(5000);min.clear();
		min.sendKeys(Utility.getProperty("value1"));
		Thread.sleep(1500);
		save_btn.click(); 
		String str4=cost.getAttribute("value");
		//compare 
		Thread.sleep(1000);
		
		if(msg1.contains("Maximum time is 24 hrs"))
		{
			test.log(LogStatus.PASS,msg1+"Entered Minute is in invalid format");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL,msg1+"Entered Minute is in valid format");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		if(str3.equals(str4))
		{
			test.log(LogStatus.PASS,str4+"Entered Minute in valid formate in numericals");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, str4+"Entered Minute in invalid formate in numericals");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(5000);min.clear();
		min.sendKeys(Utility.getProperty("minute"));
		String min1=min.getAttribute("value");
		Thread.sleep(1500);
		save_btn.click(); 
		
		WebElement up2=driver.findElement(By.xpath("//app-input[contains(@type,'number')]/div/div/div/button[1]/span[1]/mat-icon"));
		up2.click();
		String i1=cost.getAttribute("value");
		if(str3!=i1)
		{
			test.log(LogStatus.PASS,i1+"Entered minute increased by 1");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL,i1+"Entered minute not increased by 1");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		WebElement dn2=driver.findElement(By.xpath("//app-input[contains(@type,'number')]/div/div/div/button[2]/span[1]/mat-icon"));
		dn2.click();
		String d2=cost.getAttribute("value");
		if(i1!=d2)
		{
			test.log(LogStatus.PASS,d2+"Entered minute decreased by 1");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, d2+"Entered minute not decreased by 1");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(1000);
		//toggle
		WebElement no=driver.findElement(By.xpath("(//div[contains(@class,'toggle-component')])[1]/mat-button-toggle-group/mat-button-toggle[1]/button/span"));
		no.click();
		String No=no.getText();
		if(No.equals("No"))
		{
			test.log(LogStatus.PASS,"Assign Order To Departed Driver :No");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//div[contains(@class,'toggle-component')])[1]/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Assign Order To Departed Driver :Yes");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		WebElement no1=driver.findElement(By.xpath("(//div[contains(@class,'toggle-component')])[2]/mat-button-toggle-group/mat-button-toggle[1]/button/span"));
		no1.click();
		String No1=no1.getText();
		if(No1.equals("No"))
		{
			test.log(LogStatus.PASS,"Cashier report for Driver :No");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//div[contains(@class,'toggle-component')])[2]/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Cashier report for Driver :Yes");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}

	public void Click_puc_Delivery() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		puc_btn.click();
		Thread.sleep(1000);
		
		WebElement yes=driver.findElement(By.xpath("//div[@class='toggle-component-group']/mat-button-toggle-group/mat-button-toggle[2]/button/span"));
		
		WebElement no=driver.findElement(By.xpath("//div[@class='toggle-component-group']/mat-button-toggle-group/mat-button-toggle[1]/button/span"));
		no.click();
		String No=no.getText();
		if(No.equals("NO"))
		{
			test.log(LogStatus.PASS,"Enable PUC :No");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			yes.click();
			test.log(LogStatus.FAIL, "Enable PUC :Yes");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		yes.click();
		System.out.println(yes.getText());
		  String s1 = yes.getAttribute("value");
	      System.out.println("Initial value of API is : "+s1);
	     // driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[2]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("API_Key"));
	      Thread.sleep(1000);
	     
	      
		if(yes.getText().equals("YES")) {
			test.log(LogStatus.PASS,"Enable PUC :Yes");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enable PUC :No");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		if(s1==null) {
			driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[2]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("API_Key"));
		    Thread.sleep(1000);
		    test.log(LogStatus.PASS,"Enter API Key");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[3]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("Alias_Key"));
		    Thread.sleep(1000);
		    test.log(LogStatus.PASS,"Enter Alias Key");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[4]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("Cabinate_Id"));
		    Thread.sleep(1000);
		    test.log(LogStatus.PASS,"Enter Cabinate ID");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Information is already filled");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		/*
		List<WebElement> togs=driver.findElements(By.xpath("//div[@class='toggle-component-group']/mat-button-toggle-group/mat-button-toggle/button" )); 
		for(WebElement tog: togs) { tog.click(); Thread.sleep(1000); }
		 
		Thread.sleep(1000);
		puc_Yes.click();
		Thread.sleep(1000);*/
		/*
		driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[3]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("Alias_Key"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'mat-form-field-wrapper')])[4]/div[1]/div[4]/input")).sendKeys(Utility.getProperty("Cabinate_Id"));	
		Thread.sleep(2000);
		*/
	}
	
	public void Click_zone_Delivery() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		delzone_btn.click();
		add_zone.click();
		zone_name.sendKeys(Utility.getProperty("New_Store_State"));
		Thread.sleep(2000);
		cost.sendKeys(Utility.getProperty("Refund1"));
		Thread.sleep(2000);
		zone_time.sendKeys(Utility.getProperty("minute"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'drawer-footer')]/div[2]/button/span")).click();
		Thread.sleep(2000);
	}
	

	public void Click_Driver_Delivery() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver_btn.click(); Thread.sleep(500);
		
		WebElement no1=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]/button"));
		no1.click();
		String No1=no1.getText();
		if(No1.equals("NO"))
		{
			test.log(LogStatus.PASS,"Enable Tracking :No");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button")).click();
			test.log(LogStatus.FAIL, "Enable Tracking :Yes");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement y1=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button"));
		y1.click();
		String Y1=y1.getText();
		if(Y1.equals("YES"))
		{
			test.log(LogStatus.PASS,"Enable Tracking :Yes");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button")).click();
			test.log(LogStatus.FAIL, "Enable Tracking :No");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		//toggle2
		WebElement no2=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[2]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]/button"));
		no2.click();
		String No2=no1.getText();
		if(No2.equals("NO"))
		{
			test.log(LogStatus.PASS,"Direction :No");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[2]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button")).click();
			test.log(LogStatus.FAIL, "Direction :Yes");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement y2=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[2]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button"));
		y2.click();
		String Y2=y2.getText();
		if(Y2.equals("YES"))
		{
			test.log(LogStatus.PASS,"Enable Tracking :Yes");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			driver.findElement(By.xpath("//div[contains(@class,'form-card delivery')]/div/div/div[3]/div/div/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(Utility.getProperty("API_Key"));
		    Thread.sleep(1000);
		    test.log(LogStatus.PASS,"Enter API Key");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button")).click();
			test.log(LogStatus.FAIL, "Enable Tracking :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			driver.findElement(By.xpath("//app-input[contains(@label,'API Key')]/div/div/mat-form-field/div/div[1]/div[4]/input")).sendKeys(Utility.getProperty("API_Key"));
		    Thread.sleep(1000);
		    test.log(LogStatus.PASS,"Enter API Key");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//toggle
		WebElement n3=driver.findElement(By.xpath("(//div[contains(@class,'toggle-component-group')]/mat-button-toggle-group)[3]/mat-button-toggle[1]/button/span"));
		n3.click();
		String N3=n3.getText();
		if(N3.equals("NO"))
		{
			test.log(LogStatus.PASS,"Driver Departure :NO");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Driver_Departure"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Driver Departure");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//div[contains(@class,'toggle-component-group')]/mat-button-toggle-group)[3]/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Enable Tracking :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Driver_Departure"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Driver Departure");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement y3=driver.findElement(By.xpath("(//div[contains(@class,'toggle-component-group')]/mat-button-toggle-group)[3]/mat-button-toggle[2]/button/span"));
		y3.click();
		String Y3=y3.getText();
		if(Y3.equals("YES"))
		{
			test.log(LogStatus.PASS,"Order Delayed :Yes");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Delay"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Order Delayed");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//div[contains(@class,'toggle-component-group')]/mat-button-toggle-group)[3]/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Order Delayed :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Delay"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Order Delayed");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		//toggle
		WebElement n4=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[7]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]/button/span"));
		n4.click();
		String N4=n4.getText();
		if(N4.equals("NO"))
		{
			test.log(LogStatus.PASS,"Order Cancelled :NO");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Order_cancel"));;
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Order concelled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//div[contains(@class,'toggle-component-group')]/mat-button-toggle-group)[3]/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Order Cancelled :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Order_cancel"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter order cancel");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement y4=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[7]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span"));
		y4.click();
		String Y4=y4.getText();
		if(Y4.equals("YES"))
		{
			test.log(LogStatus.PASS,"Order Cancelled :Yes");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Order_cancel"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Order cancelled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[7]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Order cancelled :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Order_cancel"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Order cancelled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//toggle
		WebElement n6=driver.findElement(By.xpath("(//mat-button-toggle-group[contains(@class,'mat-button-toggle-group')])[6]/mat-button-toggle[1]/button/span"));
		n6.click();
		String N6=n6.getText();
		if(N6.equals("NO"))
		{
			test.log(LogStatus.PASS,"Order Cancelled :NO");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).sendKeys(Utility.getProperty("order"));;
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Near by");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("(//mat-button-toggle-group[contains(@class,'mat-button-toggle-group')])[6]/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Near By :No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).sendKeys(Utility.getProperty("order"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Near by");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		WebElement y5=driver.findElement(By.xpath("(//mat-button-toggle-group[contains(@class,'mat-button-toggle-group')])[6]/mat-button-toggle[2]/button/span"));
		y5.click();
		String Y5=y5.getText();
		if(Y4.equals("YES"))
		{
			test.log(LogStatus.PASS,"Near By :Yes");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).sendKeys(Utility.getProperty("Order_cancel"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Near by");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[7]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
			test.log(LogStatus.FAIL, "Near by:No");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'Your order will arrive in 10 minutes.')]")).sendKeys(Utility.getProperty("order"));
			Thread.sleep(1000);
			test.log(LogStatus.PASS,"Enter Near by");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		//toggle
				WebElement n61=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[9]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]/button/span"));
				n61.click();
				String N61=n61.getText();
				if(N61.equals("NO"))
				{
					test.log(LogStatus.PASS,"Completed :NO");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("completed"));
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"Enter Order Completed");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[9]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
					test.log(LogStatus.FAIL, "Order Completed :No");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("completed"));
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"Enter order Completed");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				WebElement y7=driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[9]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span"));
				y7.click();
				String Y7=y7.getText();
				if(Y7.equals("YES"))
				{
					test.log(LogStatus.PASS,"Order Completed :Yes");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("completed"));
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"Enter Order Completed");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					driver.findElement(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[9]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button/span")).click();
					test.log(LogStatus.FAIL, "Order Delayed :No");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("completed"));;
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"Enter Order Completed");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		
		/*
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Restaurant driver is on the way')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Driver_Departure"));
		Thread.sleep(1000);
		
		List<WebElement> togs3=driver.findElements(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[6]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button"));
		for(WebElement tog3: togs3) {
			tog3.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'delayed about few minutes')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Delay"));
		Thread.sleep(1000);
		
		List<WebElement> togs4=driver.findElements(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[7]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button"));
		for(WebElement tog4: togs4) {
			tog4.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Driver order cancelled')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("Order_cancel"));
		Thread.sleep(1000);
		
		List<WebElement> togs5=driver.findElements(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[8]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button"));
		for(WebElement tog5: togs5) {
			tog5.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order will arrive in 10 minutes.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order will arrive in 10 minutes.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("order"));
		Thread.sleep(1000);
		
		List<WebElement> togs6=driver.findElements(By.xpath("//div[contains(@class,'delivery')]/div/div[2]/div[9]/div/div[1]/div[2]/div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button"));
		for(WebElement tog6: togs6) {
			tog6.click();
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[contains(@placeholder,'Your order completed.')]/div/div/mat-form-field/div/div[1]/div[4]/textarea")).sendKeys(Utility.getProperty("completed"));
		Thread.sleep(1000);
		*/
	}
}
