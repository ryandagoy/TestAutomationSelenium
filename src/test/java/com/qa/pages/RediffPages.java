package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {

	WebDriver driver;
	
	@FindBy(linkText="Sign in")
	WebElement signInButton;
	
	public WebElement getSignInButton() {	
		return signInButton;
	}
	
	@FindBy(id="login1")
	WebElement usernameTextField;
	
	public WebElement getusernameTextField() {	
		return usernameTextField;
	}
	
	@FindBy(id="password")
	WebElement passwordTextField;
	
	public WebElement getpasswordTextField() {	
		return passwordTextField;
	}
	
	@FindBy(id="remember")
	WebElement signedInCheckbox;
	
	public WebElement getsignedInCheckbox() {	
		return signedInCheckbox;
	}
	
	@FindBy(name="proceed")
	WebElement proceedButton;
	
	public WebElement getproceedButton() {	
		return proceedButton;
	}
	
	public RediffPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
