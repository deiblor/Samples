package com.cabafa.appium;

import org.openqa.selenium.Dimension;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll {
	
	public void scroll(AndroidDriver<AndroidElement> driver) {
		
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int iniy = (int) (size.getHeight() * .60);
		int endy = (int) (size.getHeight() * .10);
		driver.swipe(x, iniy, x, endy, 1000	);
	}

}
