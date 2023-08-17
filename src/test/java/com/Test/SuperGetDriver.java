package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuperGetDriver {

	  public WebDriver driver;
	  public SuperGetDriver(){
	    driver = new ChromeDriver();
	  }
	  public WebDriver getdriver(){
	    if (driver == null){
	      driver = new ChromeDriver();
	      return driver;
	    }else{
	      return driver;
	    }
	  }
	
}
