package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	ContactsPage contact;
	
	
	// Object Repository
	
	@FindBy(xpath = "//title[text()  = 'Cogmento CRM']")
	WebElement title;
	
	@FindBy(xpath = "//span[text()='Amanbir Singh']")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//a[@href  = '/contacts']")
	WebElement contacts;
	
	@FindBy(xpath = "//a[@href  = '/deals']")
	WebElement deals;
	
	@FindBy(xpath = "//a[@href  = '/task']")
	WebElement task;
	
	
	//Initialization of elements 
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String gethomepagetitle(){
		return driver.getTitle();
	}
	
	public String getusernamelabel(){
		return usernamelabel.getText();
	}
	
	public ContactsPage getcontactspage(){
		contacts.click();
		return new ContactsPage();
	}
	
	
}
