package com.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;

public class Report_Comparison {
	
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Report Comparison");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}
	
//	@AfterMethod
//	public void TestFail(ITestResult result) throws Exception
//	{
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
//			
//			String s="data:image/png;base64,"+scnsht;
//			
//			test.log(LogStatus.FAIL, test.addScreenCapture(s));
//	
//		
//		}
//	}
	
	@Test(priority = 4)
	public void Sale_Recap_Report_Today() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		ExcelDataConfig excel1=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));

		ExcelDataConfig excel2=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));

		int w = 0;
		
		for(int i = 2; i <= 13; i++) {
			
			for(int j = 3; j <=39 ; j=j+3) {
				
				//Get the value from the store level report
				String s = excel.getData("Today", 2, 1);
				System.out.println(s);
								
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Today", 2, 1);
				System.out.println(d);
				

				if(s != "NA" && d != "NA") {
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					int l = j - 2;
					
					int m = j - 1;
					
					//Enter the value in the Comparison report from the store level report
					excel2.setreportData("Today", i, l, s);
				
					//Enter the value in the Comparison report from the Enterprise level report
					excel2.setreportData("Today", i, m, d);
					
					int n = i + 37;
					
					w = w + 1;
					System.out.println(w);
					
					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same");

						//enter the compared value
						excel2.setreport_PassedData("Today", i, j, "0.00");
					
						//
						excel2.setreport_PassedData("Today", n, w, ss+"`");

					
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Today.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Today", i, j,diff_value);
				
						excel2.setreport_FailedData("Today", n, w,diff_value);
					}
				}
				
			}
	
		}
		
		
		excel2.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));

	}
		
		


}
