package com.cabafa.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.cabafa.drivers.Android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TouchActions {

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

	@AfterMethod
	public void reset() {

		driver.resetApp();
	}

	@Test(enabled = false)
	public void tapAction() {

		TouchAction a1 = new TouchAction(driver);
		TouchAction a2 = new TouchAction(driver);
		TouchAction a3 = new TouchAction(driver);
		TouchAction a4 = new TouchAction(driver);

		a1.tap(driver.findElementByAndroidUIAutomator("text(\"Views\")")).perform();
		a2.tap(driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")")).perform();
		a3.tap(driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")")).perform();
		// a4.press(driver.findElementByAndroidUIAutomator("text(\"People
		// Names\")")).waitAction(1000).release().perform();
		a4.longPress(driver.findElementByAndroidUIAutomator("text(\"People Names\")")).perform();
	}

	@Test(enabled = false)
	public void swipeAction() {

		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Views\")")).perform();
		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")")).perform();
		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"2. Inline\")")).perform();
		new TouchAction(driver).tap(driver.findElementByXPath("//*[@content-desc='9']")).perform();
		new TouchAction(driver).press(driver.findElementByXPath("//*[@content-desc='15']"))
				.moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
	}

	@Test(enabled = true)
	public void scrollAction() {

		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Views\")")).perform();
		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));")).perform();
	}

	@Test(enabled = false)
	public void dragDrop() {

		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Views\")")).perform();
		new TouchAction(driver).tap(driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")")).perform();
		new TouchAction(driver).longPress(driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1")))
				.moveTo(driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"))).release().perform();
	}

}
