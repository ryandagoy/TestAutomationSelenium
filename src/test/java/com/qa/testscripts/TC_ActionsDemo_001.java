package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_ActionsDemo_001 extends TestBase {

	@Test
	public void DragAndDrop() throws InterruptedException {
		
		WebDriver frame = driver.switchTo().frame(0);
		
		frame.findElement(By.id("draggable"));
		
		WebElement source = frame.findElement(By.id("draggable"));
		WebElement target = frame.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(source, target).build().perform();
		Thread.sleep(3000);
		
		driver.close();
	}
	
}
