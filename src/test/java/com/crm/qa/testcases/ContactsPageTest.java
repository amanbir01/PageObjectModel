package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage  homepage;
	ContactsPage contactspage;
    String sheetname = "contact";
	
	public ContactsPageTest(){
		super();
	}
	 // Testcases should be separated that is independent of each other
	
	@BeforeMethod
	public void setup(){
	initialization();
	contactspage = new ContactsPage();
	loginpage  = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactspage = homepage.getcontactspage();
	}
	
	@Test (priority = 1)
	public void getcontactslabeltest(){
		Boolean clabel = contactspage.getcontactslabel();
		Assert.assertTrue(clabel, "Contacts label missing on the page");
	}
	
	 
	@Test (priority = 2)
	public void getnewcontacttest(){
		Boolean flag = contactspage.getnewcontact();
		Assert.assertTrue(flag, "Create New Contacts label missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMtestdata(){
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test (priority=3, dataProvider="getCRMtestdata")
	public void createnewcontacttest(String firstname, String lastname){
	     //contactspage.createnewcontact("Test", "User 4");
		contactspage.createnewcontact(firstname, lastname);
	}
	
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
