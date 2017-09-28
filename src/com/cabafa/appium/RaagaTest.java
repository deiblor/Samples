package com.cabafa.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.cabafa.drivers.Android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RaagaTest {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {

		Android android = new Android();
		driver = android.LaunchApp(driver, "com.raaga.android", "com.raaga.android.SplashScreen");
		System.out.println(driver.currentActivity());
		System.out.println(driver.getContext());
		System.out.println(driver.getPlatformName());
		System.out.println(driver.getOrientation());
	}

	@AfterTest
	public void quit() {

		driver.quit();
	}

	@AfterMethod
	public void reset() {

		driver.resetApp();
	}

	@Test
	public void basic() {

		driver.findElement(By.id("com.raaga.android:id/skip_text")).click();
		driver.findElement(By.id("com.raaga.android:id/gotit_btn")).click();
		new TouchAction(driver)
				.press(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Hindustani\"]")))
				.moveTo(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Hindi\"]"))).release().perform();
		//driver.findElementByAndroidUIAutomator(
		//		"new UiScrollable(new UiSelector()).scrollIntoView(text(\"World Music\"));").click();
		driver.findElement(By.id("com.raaga.android:id/skip_login_btn")).click();
		driver.findElement(By.id("com.raaga.android:id/toolbar_logo")).click();
		driver.findElementByAndroidUIAutomator("text(\"Radio\")").click();

	}

}
