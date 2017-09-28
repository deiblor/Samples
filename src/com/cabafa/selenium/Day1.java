package com.cabafa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Day1 {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\edgedriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://edureka.co");
			searchCourse();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchCourse() {
		
		try {
			driver.findElement(By.id("homeSearchBar")).sendKeys("Java");
			Thread.sleep(2000);
			driver.findElement(By.id("homeSearchBar")).submit();
			Thread.sleep(4000);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll (0,700)");
			driver.findElement(By.xpath("//*[@id=\"categorylistmain\"]/div[2]/div[2]/ul/li[1]/label")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Day1 myObj = new Day1();
		myObj.invokeBrowser();
		// TODO Auto-generated method stub

	}

}
