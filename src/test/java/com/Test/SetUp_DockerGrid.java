package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetUp_DockerGrid {

	@BeforeTest
	public void Start_DockerGrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start Start_DockerGrid.bat");
		
		Thread.sleep(15000);
	}
	
	@AfterTest
	public void Stop_DockerGrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start Stop_DockerGrid.bat");
		
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	}
	
}
