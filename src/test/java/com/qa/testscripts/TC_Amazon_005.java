package com.qa.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class TC_Amazon_005 extends TestBase{

	@Test(priority=1,groups="UI test")
	public void footerLinks() {
		
		List<WebElement> AllLinks = AmazonOR.getfooterLinks();
		
		int size = AllLinks.size();
		AssertJUnit.assertEquals(50,size);
		
		
		
		
	}
	
	@Test(priority=2,dependsOnMethods="footerLinks",groups="UI test")
	public void getLinkNames() {

		List<WebElement> AllLinks = AmazonOR.getfooterLinks();
		for(WebElement link:AllLinks) {
			Reporter.log(link.getText(),true);
		}
	}
	
}
