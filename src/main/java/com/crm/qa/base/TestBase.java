package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {

public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
static WebEventListener eventlistener;
	
	public TestBase(){
		
	try{	
     prop = new Properties(); 
     FileInputStream ip = new FileInputStream("D://ASB BEBO//POM//src//main//java//com//crm//qa//config//config.properties");
     prop.load(ip);
	}
	catch (FileNotFoundException e){
	System.out.println(e);
	}
	catch (IOException e){
		System.out.println(e);
	}
	}
	
	public static void initialization(){
	String browsername = prop.getProperty("browser");
	
	if(browsername.equals("chrome")){
	
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	
	else if(browsername.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
	

	e_driver = new EventFiringWebDriver(driver);  // EventFiringWebDriver class object 'e_driver' created successfully
	eventlistener = new WebEventListener(); // WebEventListener  class object 'eventlistener' created successfully
	e_driver.register(eventlistener);    // register webeventlistner class object with event firingwebdriver object
	driver = e_driver;    //Assigning eventlistener driver to driver
	
	
	
	driver.manage().window().maximize();
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	}
	
} 
