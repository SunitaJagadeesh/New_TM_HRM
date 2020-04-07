package com.tm.reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tm.Libraries.UtilitiesLib;

public class Reports extends UtilitiesLib{
	
	public static ExtentReports extent;
		
	public static ExtentTest test;
	
	public static String resultfile;
	
	//==================================================================	
	public static void intializeReports()
	{		
		extent = new ExtentReports("TestSummaryReportNew.html");
		resultfile = createResultFolder()+"\\TestSummaryReportNew.html";
		
		extent.addSystemInfo("Project Name","HRM Demo Project").
		addSystemInfo("Environment","QA")
		.addSystemInfo("Sprint Name", "sprint");
		
	
		extent.loadConfig(new File("extent.xml"));	
	}
	
	public static void startTest(String testcasename)
	{		
		test=extent.startTest(testcasename);
	}
	
	
	public static void closeTest()
	{
		extent.endTest(test);		
	}
	
	public static void flushReport()
	{
		extent.flush();
	}
	
	public static void logEvent(String status,String Description)
	{		
		switch (status.toLowerCase()) {
		case "pass":			
			//test.log(LogStatus.PASS, Description+test.addScreenCapture(getScreenShot()));			
			test.log(LogStatus.PASS, Description);
			break;
			
		case "fail":			
			test.log(LogStatus.FAIL, Description+test.addScreenCapture(getScreenShot()));			
			break;
			
		case "warning":			
			test.log(LogStatus.WARNING, Description);			
			break;
			
		case "info":			
			test.log(LogStatus.INFO, Description);			
			break;	

		default:
			System.out.println("Invalid reporting status");
			break;
		}
		
	}
	//==================================================================
	
	public static String getScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot) UtilitiesLib.driver;
		
		String screenshot=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenshot;		
	}
	//==================================================================	
	
	public static String createResultFolder()
	{		
		String path = "";
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//File f = new File(System.getProperty("user.dir")+"\\Results\\"+sdf.format(d).replace("/", "-"));
		File f = new File("\\Users\\sunita\\Documents\\TM_HRM_Automation1\\Results"+sdf.format(d).replace("/", "-"));
		
		
		if(!f.exists())
		{
			f.mkdirs();
			
			//path = System.getProperty("user.dir")+"\\Results\\"+sdf.format(d).replace("/", "-");
			path = "\\Users\\sunita\\Documents\\TM_HRM_Automation1\\Results"+sdf.format(d).replace("/", "-");
			
		}
		else
		{
			//path = System.getProperty("user.dir")+"\\Results\\"+sdf.format(d).replace("/", "-");
			path = "\\Users\\sunita\\Documents\\TM_HRM_Automation1\\Results"+sdf.format(d).replace("/", "-");
			
		}
		path = "file:///Users//sunita/Documents//TM_HRM_Automation1//";
		return path;
	}
	//==================================================================

}
