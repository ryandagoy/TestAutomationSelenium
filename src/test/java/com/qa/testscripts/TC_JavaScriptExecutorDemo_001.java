package com.qa.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_JavaScriptExecutorDemo_001 extends TestBase {

	@Test
	public void sampleJavaScript() throws InterruptedException {
		
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		
		for(int i = 0; i < 5; i++) {
			Js.executeScript("window.scrollBy(0,500)");		//top to down vertical scrolling
			Thread.sleep(1000);
		}
		
		for(int i = 5; i >= 1; i--) {
			Js.executeScript("window.scrollBy(0,-500)");	//down to top vertical scrolling
			Thread.sleep(1000);
		}
		
		//Js.executeScript("window.scrollBy(500,0)		//left to right horizontal scrolling
		//Js.executeScript("window.scrollBy(-500,0)		//right to left horizontal scrolling
	}
	
	@Test
	public void scrollToElement() throws InterruptedException {
		
		WebElement careers = AmazonOR.getAmazonCareersLink();
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		
		Js.executeScript("arguments[0].scrollIntoView", careers);
		Thread.sleep(3000);
		careers.click();
		Thread.sleep(3000);
		driver.close();
	}
}
