package com.tm.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tm.Libraries.UtilitiesLib;
import com.tm.reporting.Reports;

public class BaseClass extends UtilitiesLib {
	
	//========================================================================
	
	@BeforeSuite	
	public void setupReport()
	{
		System.out.println("******  Intializing Test Suite *******");		
		Reports.intializeReports();
		
		System.out.println("******  Test Suite is intialized sucessfully *******");
	}	
	
	@BeforeMethod
	public void launchBrowser(Method method1)  throws IOException{		
		CurrentTestCaseName = method1.getName();
		Reports.startTest(CurrentTestCaseName);
		System.out.println("<<TestStart>> TestCase Name   " + CurrentTestCaseName + "  <<TestStart>>");
		Browser = Browser.toUpperCase();
		
		switch(Browser)
		{
		case "FF":
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Jars\\Servers\\geckodriver.exe");
		    driver = new FirefoxDriver();				  
			   
			  break;
		
		case "IE":
			//For IE settings
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			
			System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();				 
			break;
			  
		case "CHROME":
			System.setProperty("webdriver.chrome.driver","//Users//sunita//Documents//Driver//chromedriver");
			 driver = new ChromeDriver();
              break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
		

//========================================================================	

	@AfterMethod
	public void closeBrowser() {		
		Reports.closeTest();
		driver.close();
		System.out.println("<<TestSuccess>> TestCase Name   " + CurrentTestCaseName + "  <<TestSuccess>>");
		System.out.println();
	
	}
	

	@AfterSuite
	public void toEnd() {
		try {
			//Reports genreport=new Reports();
			Reports.flushReport();
			
			Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Reports.resultfile);
		//driver.get("file:///Users//sunita/Documents//TM_HRM_Automation1//TestSummaryReportNew.html");
		driver.navigate().refresh();

	}
	
	//========================================================================

}
