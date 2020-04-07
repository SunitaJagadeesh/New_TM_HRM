package com.tm.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tm.BaseClass.BaseClass;
import com.tm.ScreenPages.AddDependent;
import com.tm.ScreenPages.Home;
import com.tm.ScreenPages.Login;
import com.tm.ScreenPages.MyInfo;

public class TestCases_MyInfo extends BaseClass {
	
	@Test
	public void TC10_AddDependent()
	{		
		String[] data = ReadRowData(CurrentTestCaseName);
		
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		MyInfo myinfo = PageFactory.initElements(driver, MyInfo.class);
		AddDependent dependent = PageFactory.initElements(driver, AddDependent.class);
				
		//Step1: login as a team member
		login.LoginHRM(data[0], data[1]);
		
		//Step2: Navigate MyInfo
		home.navMyInfo();
		myinfo.myinfoPageDasplayed();		
		
		//Step3: navigate to AddDependent page
		myinfo.navDependents();
		
		//Step 4: Add a dependent and verify
		dependent.addDependentAndVerify(data[2],data[3],data[4]);		
		
		//Step5: Logout
		home.logout();
		
	}

}







