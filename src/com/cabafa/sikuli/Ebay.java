package com.cabafa.sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Ebay {
	
	WebDriver driver;
	Screen myScreen;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\V\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://ebay.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void searchHome() {
		
		try {
			Pattern ebayCupon = new Pattern("C:\\Users\\V\\Pictures\\Sikuli code files\\ebay_cupon.PNG");
			Pattern ebaySpinner = new Pattern("C:\\Users\\V\\Pictures\\Sikuli code files\\ebay_spinner.PNG");
			myScreen = new Screen();
			myScreen.wait(ebayCupon,3);
			myScreen.click(ebayCupon);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll (0,300)");
			myScreen.wait(ebaySpinner, 3);
			myScreen.click(ebaySpinner);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		Ebay myObj = new Ebay();
		myObj.invokeBrowser();
		myObj.searchHome();
		// TODO Auto-generated method stub

	}

}
