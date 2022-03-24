package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Citibank_001 extends TestBase {

	@Test
	public void workingWithWindows() throws InterruptedException {
		
		Thread.sleep(3000);
		
		CitibankOR.getCitiGroupLink().click();	// triggers a new tab (2nd)
		CitibankOR.getCitiTermsAndConditionsLink().click();	//	triggers a new tab (3rd)
		
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> iter = windowID.iterator();
		
		while(iter.hasNext()) {
			String nextWindowID = iter.next();
			Reporter.log(nextWindowID);
			
			WebDriver window = driver.switchTo().window(nextWindowID);
			Reporter.log(window.getTitle());
			
			List<WebElement> AllLinks = window.findElements(By.tagName("a"));
			System.out.println("Total number of hyperlinks present on the window " + nextWindowID + " are: " + AllLinks);
		}
		
	}
	
}
