package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class TC_ScreenshotDemo_001 extends TestBase {

	@Test
	public void screenshotByElement() throws IOException {
		
		File source = AmazonOR.getAmazonLogo().getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + "logo.png";
		System.out.println(destination);
		File target = new File(destination);
		
		FileUtils.copyFile(source, target);
	}
	
	@Test
	public void screenshotByDriver() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + "logo2.png";
		System.out.println(destination);
		File target = new File(destination);
		
		FileUtils.copyFile(source, target);
		
	}
}
