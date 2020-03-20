package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homepage;
	
	LoginPageTest(){
		super();    // will call TestBase class constructor
	}
	
	
	@BeforeMethod 
	public void setUp()
	{
	initialization();
	loginpage  = new LoginPage();
	}
	
	
	@Test (priority = 1)
	public void loginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	
	@Test (priority = 2)
	public void verifycrmimage(){
		loginpage.validateCRMImage();
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test (priority = 3)
	public void clickloginbutton(){
	   loginpage.navigatetologinpage();
	}
	
	@Test (priority = 4)
	public void logintest(){
		 homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		   
		}
		
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
