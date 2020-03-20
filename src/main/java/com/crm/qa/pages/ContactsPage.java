package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;   

public class ContactsPage extends TestBase {
	
	/* Author
	 * 
	 * is Amanbir Singh
	 */

// Object Repository
@FindBy (xpath = "//div[text()='Contacts']")
@CacheLookup   // to improve script performance
WebElement contactslabel;

@FindBy(xpath = "//table[@class='ui celled sortable striped table custom-grid table-scroll']")
WebElement table;

@FindBy (xpath = "//a[@href= '/contacts/new']")
WebElement newcontact;

@FindBy (xpath = "//div[text()= 'Create New Contact']")
WebElement createcontactlabel;


@FindBy (xpath = "//input[@name='first_name']")
WebElement firstnamee;

@FindBy (xpath = "//input[@name='last_name']")
WebElement lastnamee;

@FindBy (xpath = "//button[@class='ui linkedin button']")
WebElement save;

// Initialization of Elements

public ContactsPage(){
	PageFactory.initElements(driver, this);
}

 
// Defining Methods
public boolean getcontactslabel(){
	return contactslabel.isDisplayed();
	//git 
}


public boolean getnewcontact(){
	newcontact.click();
	return createcontactlabel.isDisplayed();
}
	public void createnewcontact(String fn, String ln) {
		newcontact.click();	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    firstnamee.sendKeys(fn);
		lastnamee.sendKeys(ln);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		save.click();
		newcontact.click();	
	}
}



