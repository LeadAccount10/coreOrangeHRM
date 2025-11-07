package testngHRMS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;
	Properties config;
	Properties OR;
	
  @Test
  public void verifyWelcomePage() {
	
		driver.findElement(By.xpath(OR.getProperty("Login_userID"))).sendKeys("selenium");
		driver.findElement(By.xpath(OR.getProperty("Login_password"))).sendKeys("selenium");

		driver.findElement(By.name("Submit")).click();	
		String text=driver.findElement(By.xpath(OR.getProperty("Welcome_Selenium"))).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "Welcome selenium");
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  //Access the config.properties file into the working environment
	  FileInputStream fis=new FileInputStream("C:\\Users\\chama\\eclipse-workspace\\coreOrangeHRMProject\\src\\main\\java\\propertyFile\\config.properties");
	  //Create memory space for that config properties file
	  config=new Properties();
	  //Store config.properties file into memory space
	  config.load(fis);
	  
	  //Access the config.properties file into the working environment
	  FileInputStream fis1=new FileInputStream("C:\\Users\\chama\\eclipse-workspace\\coreOrangeHRMProject\\src\\main\\java\\propertyFile\\OR.properties");
	  //Create memory space for that config properties file
	  OR=new Properties();
	  //Store config.properties file into memory space
	  OR.load(fis1);
	  if(config.getProperty("browserName").equals("Firefox"))
	  {
		  driver=new FirefoxDriver(); 
	  }else
	  {
		  System.out.println("unable to launch browser");
	  }
	  
	  driver.get(config.getProperty("Url"));
  }
  @AfterClass
  public void afterClass() {  
	driver.findElement(By.xpath(OR.getProperty("Logout_button"))).click();
	driver.close();
  }

}
