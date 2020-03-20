package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page factory or object repository

	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']")
	WebElement loginbutton;

	@FindBy(xpath = "//div[@class='rd-navbar-brand']//a[@title='free crm home']")
	WebElement crmlogo;

	@FindBy(xpath = "//input[@placeholder='E-mail address']")
	WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement login;

	// Initializing the Page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	// Actions

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}

	public void navigatetologinpage() {

		loginbutton.click();
	}

	public HomePage login(String un, String pwd) {
		loginbutton.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		login.click();

		return new HomePage(); // returning HomePage class object
	}

}
