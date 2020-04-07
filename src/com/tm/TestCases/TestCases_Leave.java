package com.tm.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tm.BaseClass.BaseClass;
import com.tm.ScreenPages.ApplyLeave;
import com.tm.ScreenPages.Home;
import com.tm.ScreenPages.Login;


public class TestCases_Leave extends BaseClass {

	@Test
	public void TC101_verifyLoginFunctionality() {
		
		String[] data = ReadRowData(CurrentTestCaseName);
		
		// Create the page pattern to Login Page
		Login lp = PageFactory.initElements(driver, Login.class);
		//Login lp = new Login();
		// Create the page pattern to Home Page
		//Home hpg = PageFactory.initElements(driver, Home.class);		

		lp.LoginHRM(data[0], data[1]);
		//lp.LoginHRM("user02", "TM1234");
		//hpg.Exist();
		//hpg.logOut();
	}
	
	//==============================================================================
	@Test
	public void TC102_ApplyLeave() {
		
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		ApplyLeave applyleave = PageFactory.initElements(driver, ApplyLeave.class);
				
		//Step 1: Login as a team member
		login.LoginHRM("user02", "TM1234");
		
		//Step 2: Navigate Apply Leave page
		home.navApplyLeave();
		
		//Step 3: Enter leave details and click save
		applyleave.ApplyLeave();
		
		//Step 4: Navigate my Leave page
		home.navMyLeave();
		
		//Step 5: Verify leave details in My Leave page
		
		
		//Step 6: Logout
		home.logout();
		
	}
	
}
	
	
	
	
	
	
	
	
