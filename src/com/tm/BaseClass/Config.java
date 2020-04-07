package com.tm.BaseClass;

import org.openqa.selenium.WebDriver;


public class Config {
	
	public static WebDriver driver;
	public static String CurrentTestCaseName;
	public static String appURL = "http://www.testingmasters.com/hrm/";
	public String Browser = "chrome";
	public static String TestDataPath = "//Users//sunita//Documents//TM_HRM_Automation1//TestData//HRM.xlsx";
	//public static String TestDataPath = System.getProperty("user.dir")+"\\TestData\\HRM.xlsx";
		
}
