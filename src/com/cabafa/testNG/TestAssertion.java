package com.cabafa.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAssertion {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\V\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://www.facebook.com");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void closeBrowser() {

		driver.quit();
	}

	@Test
	public void testEquality() {

		Assert.assertEquals(true, isEqual(10, 11));
		System.out.println("Assertion was positive");

	}

	public boolean isEqual(int a, int b) {

		if (a == b) {
			return true;
		} else {
			return false;
		}

	}

	@Test
	public void getTitle() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
		System.out.println("Facebook page correctly loaded");
	}
}
