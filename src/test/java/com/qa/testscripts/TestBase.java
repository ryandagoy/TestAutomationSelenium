package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;
import com.qa.pages.CitibankPages;
import com.qa.pages.RediffPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	AmazonPages AmazonOR;
	CitibankPages CitibankOR;
	RediffPages RediffOR;
	
	FileInputStream fileLoc;
	Properties property;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) throws IOException {
		
		fileLoc = new FileInputStream("C:\\Users\\148280PH1\\Desktop\\SDET Training\\TestAutomationSelenium\\src\\test\\java\\com\\qa\\testdata\\credentials.properties");
		property = new Properties();
		
		property.load(fileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		
		AmazonOR = new AmazonPages(driver);
		CitibankOR = new CitibankPages(driver);
		RediffOR = new RediffPages(driver);
		driver.manage().window().maximize();
		driver.get(Url);
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	//	waits a maximum of 20 seconds
																			//	goes to the next step once page
																			//	has loaded even before 20 seconds
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tName + ".png");
		
		FileUtils.copyFile(source, target);
	}
}
