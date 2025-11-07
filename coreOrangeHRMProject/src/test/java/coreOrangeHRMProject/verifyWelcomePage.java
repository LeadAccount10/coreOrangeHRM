package coreOrangeHRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class verifyWelcomePage {

	void loginTest()
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
		
		String title=driver.getTitle();
		
		System.out.println("Title of the web page:"+title);
		
		if(title.equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Title verified successfully");
		}
		else
		{
			System.out.println("Title not verified successfully");
		}

		driver.findElement(By.name("txtUserName")).sendKeys("selenium");
		driver.findElement(By.name("txtPassword")).sendKeys("selenium");

		driver.findElement(By.name("Submit")).click();
		
		String text=driver.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
		System.out.println(text);
		
		if(text.equals("Welcome selenium"))
		{
			System.out.println("Welcome Page verified successfully");
		}
		else
		{
			System.out.println("Welcome Page not verified successfully");
		}
		driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();
		driver.close();
		
	}

	public static void main(String[] args) {
		
		verifyWelcomePage Login=new verifyWelcomePage();
		Login.loginTest();

	}


	}

