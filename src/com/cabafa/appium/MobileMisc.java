package com.cabafa.appium;

import java.io.IOException;
import org.testng.annotations.*;

import com.cabafa.drivers.Android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class MobileMisc {
	AndroidDriver<AndroidElement> driver;
	AppiumDriverLocalService service;

	@BeforeTest
	public void setup() throws IOException, InterruptedException {

		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		Android android = new Android();
		//android.StartAppium();
		//driver = android.InstallApp(driver, "ApiDemos-debug.apk");
		driver = android.LaunchApp(driver, "io.appium.android.apis", "io.appium.android.apis.ApiDemos");
		System.out.println(driver.currentActivity());
		System.out.println(driver.getContext());
		System.out.println(driver.getPlatformName());
		System.out.println(driver.getOrientation());
	}

	@AfterTest
	public void quit() {

		driver.quit();
		service.stop();
	}

	@AfterMethod
	public void reset() {

		driver.resetApp();
	}
	
	@Test
	public void validateActivity() {
		
		System.out.println(driver.currentActivity());
		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Views\")")).perform();
		System.out.println(driver.currentActivity());
		Scroll screen = new Scroll();
		screen.scroll(driver);
		screen.scroll(driver);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		System.out.println(driver.currentActivity());
	}
}
