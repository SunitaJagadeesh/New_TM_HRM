package com.tm.Libraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tm.BaseClass.BaseClass;
import com.tm.reporting.Reports;

public class Weblibrary extends BaseClass {
	
//======================= Methods Begin ===================================================
	public static boolean launchApplication(String URL) {

		boolean status;
		try {
			driver.get(URL);
			status = true;
		} 
		catch (Exception e) 
		{
			status = false;
		}
		return status;
	}
//==========================================================================
	/*
	 * Method Name : setText
	 * 
	 * Description : This method is used to send the data to input text field
	 * 
	 * Input:: WebElement and text Data
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 * 
	 * 
	 */

	public static boolean setText(WebElement element, String value) {
		boolean status;

		try {			
			element.click();
			element.clear();
			element.sendKeys(value);
			status = true;
		} 
		catch (Exception e) 
		{
			status = false;
		}

		return status;

	}
	//==========================================================================
	/*
	 * Method Name : setTextandEscape
	 * 
	 * Description : This method is used to send the data to input text field
	 * and Click on Escape button
	 * 
	 * Input:: WebElement and text Data
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 * 
	 * 
	 */

	public static boolean setTextandEscape(WebElement element, String value) {
		boolean status;

		try {
			element.click();
			element.clear();
			element.sendKeys(value);
			element.sendKeys(Keys.ESCAPE);
			status = true;
		} 
		catch (Exception e) 
		{
			status = false;
		}

		return status;

	}
	//==========================================================================
	/*
	 * Method Name : logEvent
	 * 
	 * Description : This method is used to print the log status and take the
	 * screenshots
	 * 
	 * Input::boolean status, PassDescription , FailDescription
	 * 
	 * Output: Log status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 * 
	 * 
	 */

	public static void logEvent(boolean status, String PassDescription, String FailDescription) {

		if (status) {
			Reports.logEvent("Pass", PassDescription);
			System.out.println("		<<>> " + PassDescription + " <<>>");

		} else {
			Reports.logEvent("Fail", FailDescription);
			System.out.println("		<<>> " + FailDescription + " <<>>");

		}

	}
	//==========================================================================
	/*
	 * Method Name : clickElement
	 * 
	 * Description : This method is used to Click the Element
	 * 
	 * Parameters:: WebElement
	 * 
	 * Output: boolean status
	 * 
	 * Author : Testing Masters Technologies
	 * 
	 * Date of creation: 20th mar 2019
	 * 
	 * Modified By:
	 * 
	 * Modified Date: 
	 * 
	 */
	public static boolean clickElement(WebElement element) {

		boolean status;

		try {
			element.click();
			status = true;
		} 
		catch (Exception e) 
		{
			status = false;
		}	

		return status;
	}
	//==========================================================================	

	public static boolean moveToElement(WebElement element) {

		boolean status;
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
			status = true;
		} 
		catch (Exception e) 
		{
			status = false;
		}
		return status;
	}
	//==========================================================================	
	
	public static boolean isExist(WebElement element) {

		boolean status;
		try {
			element.isDisplayed();
			status=true;
		} 
		catch (Exception e) 
		{
			status = false;
		}

		return status;
	}	
	//==========================================================================
	public static boolean selectByText(WebElement element, String Selected_value) {

		boolean status;
		
		try {
			Select sc=new Select(element);
			sc.selectByVisibleText(Selected_value);
			
			status=true;
		}
		
		catch (Exception e) 
		{
			status = false;
		}
		
		return status;
	}
//====================================================
	public static int getRowCount(List<WebElement> table) {

		boolean status;
		int n=0;
		
		try {
			n = table.size();			
			status=true;
		}
		
		catch (Exception e) 
		{
			status = false;
		}	
		
		logEvent(status, "Get row count successful", "Get row count unsuccessful");
		return n;
	}	
//====================================================	
	public static String getCellText(WebElement cell) {

		boolean status;
		String cellText = "";
		
		try {
			cellText = cell.getText();			
			status=true;
		}
		
		catch (Exception e) 
		{
			status = false;
		}	
		
		logEvent(status, "Get cell text successful", "Get cell text unsuccessful");
		
		return cellText;
	}	
//====================================================
	public static void wait(int seconds)
	{
		try	{
			Thread.sleep(seconds*1000);
		}
		catch(Exception e)	{
			
		}
	}
	//====================================================
	
//=====================Methods End =====================================================
}
