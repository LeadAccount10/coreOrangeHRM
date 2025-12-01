package com.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Util.CommonUtils;

public class BasePage {
	WebDriver driver;

	@BeforeTest
	public void setup() 
	{
		CommonUtils.readPropertiesFile();
		driver=CommonUtils.launchBrowserAndNavigateToApp();
	}
	
	@AfterTest
	public void close() 
	{
	//	driver.quit();
	}

}
