package com.cabafa.poi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class POITest extends Base {

	public class GmailTestDemo {

		WebDriver driver = null;

		@Test(dataProvider = "getParams") // dataProvider value should be equal to @DataProvider method name
		public void doLogin(String username, String password, String browser) { // no. of parameter = no. of columns
			if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Selenium\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://facebook.com");
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.id("loginbutton")).click();
			//driver.quit();
		}

		@DataProvider
		public Object[][] getParams() throws IOException {

			setDataFile("C:\\Users\\V\\Desktop", "TestData.xlsx", "Sheet1");
			Object data[][] = getDataFromSheet();
			return data;
		}

	}

}
