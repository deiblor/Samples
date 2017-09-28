package com.cabafa.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.cabafa.drivers.WebBrowsers;

public class TestWebBrowsers {
	WebDriver driver;
	
	@BeforeTest
	public void setUpBrowser() {
		WebBrowsers browser = new WebBrowsers();
		driver = browser.invokeChrome(driver);
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	public void testAmazon() {
		driver.get("http://www.amazon.com");
		
	}

}
