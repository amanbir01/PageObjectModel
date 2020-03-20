package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage  homepage;
	ContactsPage contactspage;
	
	public HomePageTest(){
		super();
	}
	 // Testcases should be separated that is independent of each other
	
	@BeforeMethod
	public void setup(){
	initialization();
	contactspage = new ContactsPage();
	loginpage  = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void gethomepagetitletest(){
		String hometitle = homepage.gethomepagetitle();
		Assert.assertEquals(hometitle, "Cogmento CRM" , "In-correct Title");
	}
	
	@Test (priority = 2)
	public void getusernamelabeltest(){
		String username  = homepage.getusernamelabel();
		Assert.assertEquals(username, "Amanbir Singh" , "In-correct username is getting displayed");
	}
	
	@Test (priority = 3)
	public void getcontactspagetest(){
		contactspage = homepage.getcontactspage();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
