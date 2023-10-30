package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AAA_Healenium_On_Test {
	WebDriver driver;

	@Test
	public void Test_HealeniumTool()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver1=new ChromeDriver();
		
		SelfHealingDriver delegate=SelfHealingDriver.create(driver1);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		
				
	}

}
