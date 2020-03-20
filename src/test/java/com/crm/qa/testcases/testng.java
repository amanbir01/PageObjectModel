package com.crm.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testng {

	WebDriver driver;

	@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Parameters({ "url" })
	public void openberowser(String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		int i = 9/0;
	}	

}
