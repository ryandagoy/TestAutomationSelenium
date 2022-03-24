package com.qa.testscripts;

import org.testng.annotations.Test;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import com.qa.pages.AmazonPages;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Test Scenario:
	1. Open the browser (Chrome)
	2. Enter the Amazon URL
	3. Select Books as Category
	4. Enter "Da Vinci Code" in the search text field
	5. Click the magnifier button
	6. Check if all the elements related to search item are loaded
	Close the browser
	*/

public class TC_Amazon_002 {
	
	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void searchItem() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver cdriver = new ChromeDriver();
		AmazonPages AmazonOR = new AmazonPages(cdriver);
		
		cdriver.manage().window().maximize();
		
		cdriver.get("https://www.amazon.com/");
		
		//static programming (not advisable) - test object descriptions are hard coded
		//typecasting for dropdowns only
		
		/*
		WebElement category = cdriver.findElement(By.id("searchDropdownBox"));
		Select dropdown = new Select(category);
		dropdown.selectByVisibleText("Books");
		Thread.sleep(3000);
		
		cdriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Da Vinci Code");
		Thread.sleep(3000);
		cdriver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		*/
		
		//dynamic programming using Page Object Model
		//where test object descriptions are fetched from an object repository  (com.qa.pages)
		AmazonOR.getCategory().selectByVisibleText("Books");
		Thread.sleep(3000);
		AmazonOR.getSearchTxtField().sendKeys("Da Vinci Code");
		Thread.sleep(3000);
		AmazonOR.getMagnifierBtn().click();
		Thread.sleep(3000);
		
		Boolean contains = cdriver.getTitle().contains("Da Vinci Code");
		
		if(contains) {
			Reporter.log("Searched successfully", true);
		}
		else {
			Reporter.log("Searched unsuccessfully", true);
		}
		
		Thread.sleep(3000);
		
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println("Total number of items are: " + allItems.size());
		
		for(WebElement item:allItems) {
			Reporter.log(item.getText(), true);
		}
		Thread.sleep(3000);
		
		cdriver.close();
	}
}
