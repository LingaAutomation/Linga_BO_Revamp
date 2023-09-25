package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import Utility.ExcelDataConfig;

public class Excel_Report_Comparison {
	
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
	
	@Test(priority = 4)
	public void Sale_Recap_Report_Today() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Today", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Today", i, j);
				System.out.println("The value of ("+i+","+j+") in Today sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Today", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Today", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Today", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Today", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Today", i, sd, "NA");
				
					//
					excel2.setreportData("Today", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Today", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Today", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Today", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Today", i, l, d);
					}
					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Today's sheet ");
						
						//enter the compared value
						excel2.setreport_PassedData("Today", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Today", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Today.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Today", i, sd,diff_value);
				
						excel2.setreport_FailedData("Today", i+37, w,diff_value);
					}	
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 5)
	public void Sale_Recap_Report_Yesterday() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Yesterday", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Yesterday", i, j);
				System.out.println("The value of ("+i+","+j+") in Yesterday sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Yesterday", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Yesterday", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Yesterday", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Yesterday", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Yesterday", i, sd, "NA");
				
					//
					excel2.setreportData("Yesterday", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Yesterday", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Yesterday", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Yesterday", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Yesterday", i, l, d);
					}
					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Yesterday's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Yesterday", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Yesterday", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Yesterday.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Yesterday", i, sd,diff_value);
				
						excel2.setreport_FailedData("Yesterday", i+37, w,diff_value);
					}
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 6)
	public void Sale_Recap_Report_Last_N_Days() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Last N days", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Last N days", i, j);
				System.out.println("The value of ("+i+","+j+") in Last N days sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last N days", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last N days", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last N days", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last N days", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Last N days", i, sd, "NA");
				
					//
					excel2.setreportData("Last N days", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last N days", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last N days", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last N days", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last N days", i, l, d);
					}
					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Last N days's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Last N days", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Last N days", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Last N days.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Last N days", i, sd,diff_value);
				
						excel2.setreport_FailedData("Last N days", i+37, w,diff_value);
					}
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 7)
	public void Sale_Recap_Report_This_Week() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("This Week", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("This Week", i, j);
				System.out.println("The value of ("+i+","+j+") in This Week sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This Week", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This Week", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This Week", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This Week", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("This Week", i, sd, "NA");
				
					//
					excel2.setreportData("This Week", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This Week", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This Week", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This Week", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This Week", i, l, d);
					}
					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in This Week's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("This Week", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("This Week", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for This Week.The value diff is : "+diff);
						

						excel2.setreport_FailedData("This Week", i, sd,diff_value);
				
						excel2.setreport_FailedData("This Week", i+37, w,diff_value);
					}
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 8)
	public void Sale_Recap_Report_Last_Week() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Last Week", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Last Week", i, j);
				System.out.println("The value of ("+i+","+j+") in Last Week sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last Week", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last Week", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last Week", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last Week", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Last Week", i, sd, "NA");
				
					//
					excel2.setreportData("Last Week", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last Week", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last Week", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last Week", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last Week", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Last Week's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Last Week", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Last Week", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Last Week.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Last Week", i, sd,diff_value);
				
						excel2.setreport_FailedData("Last Week", i+37, w,diff_value);
					}			
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 9)
	public void Sale_Recap_Report_Last_7_Days() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Last 7 days", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Last 7 days", i, j);
				System.out.println("The value of ("+i+","+j+") in Last 7 days sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 7 days", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 7 days", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 7 days", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 7 days", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Last 7 days", i, sd, "NA");
				
					//
					excel2.setreportData("Last 7 days", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 7 days", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 7 days", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 7 days", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 7 days", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Last 7 days's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Last 7 days", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Last 7 days", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Last 7 days.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Last 7 days", i, sd,diff_value);
				
						excel2.setreport_FailedData("Last 7 days", i+37, w,diff_value);
					}					
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 10)
	public void Sale_Recap_Report_This_Month() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("This month", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("This month", i, j);
				System.out.println("The value of ("+i+","+j+") in This month sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This month", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This month", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This month", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This month", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("This month", i, sd, "NA");
				
					//
					excel2.setreportData("This month", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This month", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This month", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("This month", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("This month", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in This month's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("This month", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("This month", i+37, w, ss+"`");						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for This month.The value diff is : "+diff);
						

						excel2.setreport_FailedData("This month", i, sd,diff_value);
				
						excel2.setreport_FailedData("This month", i+37, w,diff_value);
					}
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 11)
	public void Sale_Recap_Report_Last_Month() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Last month", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Last month", i, j);
				System.out.println("The value of ("+i+","+j+") in Last month sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last month", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last month", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last month", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last month", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Last month", i, sd, "NA");
				
					//
					excel2.setreportData("Last month", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last month", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last month", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last month", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last month", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Last month's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Last month", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Last month", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Last month.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Last month", i, sd,diff_value);
				
						excel2.setreport_FailedData("Last month", i+37, w,diff_value);
					}
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 12)
	public void Sale_Recap_Report_Last_30_Days() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Last 30 days", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Last 30 days", i, j);
				System.out.println("The value of ("+i+","+j+") in Last 30 days sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 30 days", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 30 days", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 30 days", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 30 days", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Last 30 days", i, sd, "NA");
				
					//
					excel2.setreportData("Last 30 days", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 30 days", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 30 days", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Last 30 days", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Last 30 days", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Last 30 days's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Last 30 days", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Last 30 days", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Last 30 days.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Last 30 days", i, sd,diff_value);
				
						excel2.setreport_FailedData("Last 30 days", i+37, w,diff_value);
					}					
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 13)
	public void Sale_Recap_Report_Specific_Date() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Specific Date", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Specific Date", i, j);
				System.out.println("The value of ("+i+","+j+") in Specific Date sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Specific Date", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Specific Date", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Specific Date", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Specific Date", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Specific Date", i, sd, "NA");
				
					//
					excel2.setreportData("Specific Date", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Specific Date", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Specific Date", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Specific Date", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Specific Date", i, l, d);
					}


					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Specific Date's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Specific Date", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Specific Date", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Specific Date.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Specific Date", i, sd,diff_value);
				
						excel2.setreport_FailedData("Specific Date", i+37, w,diff_value);
					}			
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}

	@Test(priority = 14)
	public void Sale_Recap_Report_Date_Range() throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig("./Excel Files/Sale Report.xlsx");

		ExcelDataConfig excel1=new ExcelDataConfig("./Excel Files/Enterprise Report.xlsx");

		ExcelDataConfig excel2=new ExcelDataConfig("./Excel Files/Comparison Report.xlsx");
		
		for(int i = 2; i <= 13; i++) {
			int k = 1, l = 2,w = 0;int sd = 0;
			for(int j = 2; j <= 26; j=j+2) {
				
				//Get the value from the store level report
				String s = excel.getData("Date Range", i, j);
				System.out.println("The value of ("+i+","+j+") is : "+s);
				
				//Get the value from the Enterprise level sale report
				String d = excel1.getData("Date Range", i, j);
				System.out.println("The value of ("+i+","+j+") in Date Range sheet is : "+d);
				w = w + 1;
				sd = sd + 3;
				if(s.equals("NA") && d.equals("NA")) {
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Date Range", i, 1, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Date Range", i, 2, "NA");
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Date Range", i, k, "NA");
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Date Range", i, l, "NA");
					}
					
					//enter the compared value
					excel2.setreportData("Date Range", i, sd, "NA");
				
					//
					excel2.setreportData("Date Range", i+37, w, "NA");
				}
				else{
					//converting the string value into Double
					double ss = Double.parseDouble(s);
					
					//Converting the string value into Double
					double dd = Double.parseDouble(d);
					
					if(j == 2) {
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Date Range", i, 1, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Date Range", i, 2, d);
					}
					else {
						k = k + 3;
						
						l = l + 3;
						
						//Enter the value in the Comparison report from the store level report
						excel2.setreportData("Date Range", i, k, s);
					
						//Enter the value in the Comparison report from the Enterprise level report
						excel2.setreportData("Date Range", i, l, d);
					}

					//compare the store level report and enterprise level report
					if(ss==dd)
					{
						test.log(LogStatus.PASS, "Compared Store value and the Enterprise level Store value is same in Date Range's sheet");
						
						//enter the compared value
						excel2.setreport_PassedData("Date Range", i, sd, "0.00");
					
						//
						excel2.setreport_PassedData("Date Range", i+37, w, ss+"`");
						
					}
					else
					{
						double diff=ss-dd;
						String diff_value=String.valueOf(diff);
						
						test.log(LogStatus.FAIL, "Compared Store value and the Enterprise level Store value is not equal for Date Range.The value diff is : "+diff);
						

						excel2.setreport_FailedData("Date Range", i, sd,diff_value);
				
						excel2.setreport_FailedData("Date Range", i+37, w,diff_value);
					}					
				}
			}
			excel2.toWrite("./Excel Files/Comparison Report.xlsx");
		}
	}
}
