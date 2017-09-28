package com.cabafa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseElementLocators {
	
	WebDriver driver;
	
	public void invokeBrowser(String url) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\V\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void elementLocatorsAmazon() {
		
		invokeBrowser("http://www.amazon.com.mx");
		driver.findElement(By.linkText("Promociones")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Prueba")).click();
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo laptops");
		driver.findElement(By.className("nav-input")).click();
	}
	
	public void elementLocatorsFacebook() {
		
		invokeBrowser("http://facebook.com");
		driver.findElement(By.name("firstname")).sendKeys("Javier");
		driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
	}
	
	public void elementLocatorsYatra() {
		
		invokeBrowser("http://www.yatra.com");
		driver.findElement(By.xpath("//*[@id=\"BE_flight_form\"]/div/div[2]/ul/li[3]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"PegasusCal-0\"]/div[3]/div[1]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"a_2017_11_10\"]")).click();
	}
	
	public void closeBrowser() {
		
		driver.close();
	}

	public static void main(String[] args) {
		
		UseElementLocators myObj = new UseElementLocators();
		//myObj.elementLocatorsAmazon();
		//myObj.elementLocatorsFacebook();
		myObj.elementLocatorsYatra();
		// TODO Auto-generated method stub

	}

}
