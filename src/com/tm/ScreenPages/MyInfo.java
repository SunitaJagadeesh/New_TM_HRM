package com.tm.ScreenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tm.Libraries.Weblibrary;

public class MyInfo extends Weblibrary{
	
	@FindBy(xpath = "//a[text()='Dependents']")
	public static WebElement link_Dependents;
	
	@FindBy(xpath = "//a[text()='Personal Details']")
	public static WebElement link_PersonalDetails;
	
	@FindBy(xpath = "//a[text()='Contact Details']")
	public static WebElement link_ContactDetails;
	
	@FindBy(xpath = "//h1[text()='Personal Details']")
	public static WebElement header_PersonalDetails;
	
	
	public void navDependents(){
		boolean status;
		status = clickElement(link_Dependents);
		logEvent(status, "Dependents link clicked", "Dependents link mot clicked");
	}
	
	public void myinfoPageDasplayed(){
		boolean status;
		status = isExist(header_PersonalDetails);
		logEvent(status, "MyInfo page displayed", "MyInfo page not displayed");
	}

}
