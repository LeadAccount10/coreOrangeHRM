package com.Util;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonUtils {
	public static Properties config;
	public static WebDriver driver;
	public static FileInputStream fis;
	public static void readPropertiesFile()
	{
		
		try {
			 FileInputStream fis=new FileInputStream("C:\\Users\\chama\\eclipse-workspace\\coreOrangeHRMProject\\src\\main\\resources\\config.properties");
			  config=new Properties();
			  config.load(fis);
		}
		catch(Exception e)
		{
			
		}
	}
	public static void launchBrowserAndNavigateToApp()
	{
		String	browserName=config.getProperty("browser");
		try {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}else {
	
			System.out.println("Unable to launch the browser");
		}
			driver.get(config.getProperty("Url"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
 public static WebElement findElement(By by)
 {
	 WebElement element=null;
	 try {
		
		 element = driver.findElement(by);
	 
	 }catch(Exception e) {
		
		 TestNGUtility.assertFail(e.getMessage()); 
	
	 }
	 return element;
 }
 //The method is used to delete all the text in a web element(like a text box or input field)

 public static void clearWholeText(By by)
{
	try {
		findElement(by).clear();
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
} 
 public static void enterValue(By by,String value,boolean eClear)
{
	try {
		if(eClear)
			clearWholeText(by); 
		findElement(by).sendKeys(value);
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}

public static void clickElement(By by) {
	try {
	findElement(by).click();
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}

public static String getElementText(By by) {
	String elementText=null;
	try {

		elementText = findElement(by).getText();//	
		System.out.println(elementText);
		

	} catch (Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
	return elementText;
}


public static void hardWait(int millis) {
	try {
		Thread.sleep(millis * 2000);
	} catch (Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}



}
