package com.tm.ScreenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.tm.Libraries.Weblibrary;

public class Login extends Weblibrary {
	
	//Username Field Webelement
	@FindBy(xpath = "//input[@id='txtUsername']")
	public static WebElement Edit_UserName;
	
	//Password field Webelement
	@FindBy(xpath = "//input[@id='txtPassword']")
	public static WebElement Edit_Password;

	//Login button Webelement
	@FindBy(xpath = "//input[@id='btnLogin']")
	public static WebElement Btn_Login;	
	
	//==================================================
	public void LoginHRM(String uid, String pwd) {
		boolean status;		
		
		status=launchApplication(appURL);
		logEvent(status, "Application launched Sucessfully", "Unable to launch the Application");
		
		status = setText(Edit_UserName, uid);
		logEvent(status, "Username enter Sucessfully", "Unable to enter Username ");
	
		status = setText(Edit_Password, pwd);
		logEvent(status, "Password enter Sucessfully", " unable to enter Password ");
		
		status = clickElement(Btn_Login);
		logEvent(status, "Able to click the Login button", "unable to Click the Login button");
	}
	
	

}
