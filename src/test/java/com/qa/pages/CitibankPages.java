package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitibankPages {

	WebDriver driver;
	
	@FindBy(linkText="CITIGROUP.COM")
	WebElement CitiGroupLink;
	
	public WebElement getCitiGroupLink() {	
		return CitiGroupLink;
	}
	
	@FindBy(linkText="TERMS AND CONDITIONS")
	WebElement CitiTermsAndConditions;
	
	public WebElement getCitiTermsAndConditionsLink() {	
		return CitiTermsAndConditions;
	}
	
	public CitibankPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
}
