package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_001 {

	public static void main(String[] args) throws InterruptedException {
		
		//Open the browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\148280PH1\\Desktop\\SDET Training\\Tools\\Selenium Drivers\\chromedriver.exe");
		
		//WebDriverManager.edgedriver().setup();
		//EdgeDriver edriver = new EdgeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxDriver fdriver = new FirefoxDriver();
		
		//WebDriverManager.iedriver().setup();
		//InternetExplorerDriver idriver = new InternetExplorerDriver();
		
		WebDriverManager.chromedriver().setup();
		//ChromeDriver cdriver = new ChromeDriver();
		WebDriver cdriver = new ChromeDriver();
		
		cdriver.manage().window().maximize();
		cdriver.get("https://www.amazon.com/");
		cdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		String title = cdriver.getTitle();
	    System.out.println(title);
	    
	    if(title.contains("Amazon")) {
	    	System.out.println("Amazon page is loaded");
	    }
	    
	    String url = cdriver.getCurrentUrl();
	    System.out.println(url);
	    
	    Thread.sleep(5000);
	    
	    //String pagesource = cdriver.getPageSource();		// HTML page sources
	    //System.out.println(pagesource);
	    
	    String windowhandle = cdriver.getWindowHandle();		// window id of the current window
	    System.out.println(windowhandle);
	    
	    //cdriver.findElement("locator");		// reach the webelement present on the page using the locator
	    //cdriver.findElements("locator");		// reach the group of webelements present on the page using the locator
	    
	    //cdriver.switchTo().window("");		// switch to window/tab based on window id
	    //cdriver.switchTo().frame("");			// switch to frame based on frame id
	    //cdriver.switchTo().alert();			// switch to alert window
	    
	    cdriver.navigate().to("https://www.google.com/");
	    Thread.sleep(5000);
	    cdriver.navigate().back();
	    Thread.sleep(5000);
	    cdriver.navigate().forward();
	    Thread.sleep(5000);
	    
	    cdriver.close();		// current browser instance will be closed
	    cdriver.quit();			// closes all browser instances (tabs/windows)

	}
	
}
