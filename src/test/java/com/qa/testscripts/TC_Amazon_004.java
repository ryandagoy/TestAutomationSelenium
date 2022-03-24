package com.qa.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TC_Amazon_004 extends TestBase{

	@Test(groups="UI test")
	public void newUserReg() {

		Actions act = new Actions(driver);

		WebElement ele = AmazonOR.getAccountsandLists();		
		act.moveToElement(ele).build().perform();

		AmazonOR.getstarthereLink().click();
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 40);	//	waits for 40 seconds
		
		explicitWait.until(ExpectedConditions.titleContains("Registration"));	//	if loads in 20 seconds, 
																				//	other 20 seconds will be skipped
		
		String title = driver.getTitle();
		Reporter.log(title,true);
		AssertJUnit.assertEquals(title, "Registration");
		
		/*
		boolean contains = driver.getTitle().contains("Registration");

		if(contains) {
			Reporter.log("User is landed on the registration page");
		}else {
			Reporter.log("User is landed on the registration page");
		}*/


	}

}
