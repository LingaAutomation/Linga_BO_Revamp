package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Healenium_On_Test {
	SelfHealingDriver driver;

	@Test
	public void Test_HealeniumTool() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/"); 
		
		Thread.sleep(15000);
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		
				
	}

}
