package com.cabafa.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.cabafa.drivers.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FindElementsBasic {
	
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
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		driver.findElement(By.id("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).clear();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Test text");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
	}

}
