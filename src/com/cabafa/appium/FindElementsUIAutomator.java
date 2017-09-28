package com.cabafa.appium;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cabafa.drivers.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FindElementsUIAutomator {
	
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		
		Android android = new Android();
		driver = android.InstallApp(driver, "ApiDemos-debug.apk");

	}
	
	@AfterTest
	public void quit() {
		
		driver.quit();
	}
	
	@Test
	public void testRun() {
		
		// Find elements using attributes
		//	driver.findElementByAndroidUIAutomator("attribute(\"value\")")
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
		// Find properties of elements
		// 	driver.findElementByAndroidUIAutomator("new UISelector.property(\"value\")").click();
		driver.findElementsByAndroidUIAutomator("new UISelector().clickable(true)").size();
		
	}	

}
