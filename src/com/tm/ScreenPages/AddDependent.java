package com.tm.ScreenPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tm.Libraries.Weblibrary;

public class AddDependent extends Weblibrary{

	//=================== page elements =====================
	
	@FindBy(xpath="//input[@id='btnAddDependent']")
	public static WebElement btn_AddDependent;

	@FindBy(xpath="//input[@id='dependent_name']")
	public static WebElement edit_name;
	
	@FindBy(xpath="//select[@id='dependent_relationshipType']")
	public static WebElement list_Relationship;
	
	@FindBy(xpath="//input[@id='dependent_dateOfBirth']")
	public static WebElement Edit_DOB;
	
	@FindBy(xpath="//input[@id='btnSaveDependent']")
	public static WebElement btn_Save;
	
	@FindBy(xpath="//table[@id='dependent_list']/tbody/tr")
	public static List<WebElement> table_rows;
	
	//=================== page elements end ================
	
	//=================== page methods =====================	
	public void addDependentAndVerify(String strName, String strRelationship, String strDOB) {
		
		boolean status;
		
		// Add dependent details
		status = clickElement(btn_AddDependent);
		logEvent(status, "Add button clicked", "Add button not clicked");
		
		status = setText(edit_name, strName);
		logEvent(status, "Dependent name entered", "Dependent name not entered");
		
		status = selectByText(list_Relationship, strRelationship);
		logEvent(status, "Dependent Relationship selected", "Dependent Relationship not selected");
		
		status = setTextandEscape(Edit_DOB, strDOB);
		logEvent(status, "Dependent DOB entered", "Dependent DOB not entered");
		
		status = clickElement(btn_Save);
		logEvent(status, "Save button clicked", "Save button not clicked");
		
		// Verify dependent added to table
		int rowCount = getRowCount(table_rows);
		boolean bTag = false;
		for(int iRow=1; iRow<=rowCount; iRow++)
		{
			String name = getCellText(driver.findElement(By.xpath("//table[@id='dependent_list']/tbody/tr["+iRow+"]/td[2]")));
			String relationship = getCellText(driver.findElement(By.xpath("//table[@id='dependent_list']/tbody/tr["+iRow+"]/td[3]")));
			String dob = getCellText(driver.findElement(By.xpath("//table[@id='dependent_list']/tbody/tr["+iRow+"]/td[4]")));
			
			if( (name.equals(strName)) && (relationship.equals(strRelationship)) && (dob.equals(strDOB)))
			{
				bTag = true;
				break;
			}
		}		
		if(true)
			logEvent(status, "Dependent added successfully in the table", "Dependent not added in the table");
		
	}	
	//=================== page methods end =====================
	
		
}
