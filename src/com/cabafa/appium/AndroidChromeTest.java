package com.cabafa.appium;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.cabafa.drivers.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidChromeTest {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException{
		
		Android android = new Android();
		driver = android.AndroidChrome(driver);
				
	}
	
	@Test
	public void loginToFacebook() {
		
		driver.get("http://m.facebook.com");
		System.out.println("Title "+driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("javier@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("asdfgh");
		driver.findElement(By.name("login")).click();
		
	}

}
