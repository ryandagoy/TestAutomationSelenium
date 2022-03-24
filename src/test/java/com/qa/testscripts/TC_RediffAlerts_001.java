package com.qa.testscripts;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RediffAlerts_001 extends TestBase {

	@Test
	public void LoginAction() throws InterruptedException {
		
		RediffOR.getSignInButton().click();
		
		boolean contains = driver.getCurrentUrl().contains("login");
		
		if(contains) {
			Reporter.log("User is on the log in page");
			
			boolean enabled = RediffOR.getproceedButton().isEnabled();
			
			if(enabled) {
				RediffOR.getproceedButton().click();
				
				Alert alert = driver.switchTo().alert();
				Reporter.log(alert.getText());
				
				alert.accept();
			}
			
			RediffOR.getusernameTextField().sendKeys(property.getProperty("username"));
			RediffOR.getpasswordTextField().sendKeys(property.getProperty("password"));
			
			boolean selected = RediffOR.getsignedInCheckbox().isSelected();
			
			if(selected) {
				Reporter.log("The checkbox is checked by default", true);
				RediffOR.getsignedInCheckbox().click();
				Thread.sleep(3000);
			}
		}
	}
	
}
