package com.cabafa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\V\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			getCommands();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getCommands() {
		
		try {
			driver.get("http://www.amazon.com.mx");
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of the page is: "+ titleOfThePage);
			driver.findElement(By.linkText("Promociones")).click();
			String currentURL = driver.getCurrentUrl();
			System.out.println("The current URL is: "+ currentURL);
			System.out.println("The current page source is: "+ driver.getPageSource());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		TestGetCommands myObj = new TestGetCommands();
		myObj.invokeBrowser();
		// TODO Auto-generated method stub

	}

}
