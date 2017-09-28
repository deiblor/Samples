package com.cabafa.drivers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Android {
	
	public void StartAppium() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("cmd /c start C:\\Users\\V\\eclipse-workspace\\Training\\src\\appium.bat");
		Thread.sleep(35000);
	}

	public AndroidDriver<AndroidElement> InstallApp(AndroidDriver<AndroidElement> driver, String app) throws MalformedURLException {

		File src = new File("src");
		File apk = new File(src,app);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "CB5A2ALXSN");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		//capabilities.setCapability("noReset", "true");
		capabilities.setCapability("app", apk.getAbsolutePath());

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public AndroidDriver<AndroidElement> LaunchApp(AndroidDriver<AndroidElement> driver, String pack, String activity) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "CB5A2ALXSN");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		//capabilities.setCapability("noReset", "true");
		capabilities.setCapability("appPackage", pack);
		capabilities.setCapability("appActivity", activity);
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public AndroidDriver<AndroidElement> AndroidChrome(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "CB5A2ALXSN");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("noReset", "true");

		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		
		return driver;
	}

}
