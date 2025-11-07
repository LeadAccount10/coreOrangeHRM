package com.Pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class LoginPage {
public static Properties properties;
	
	//Web locators
	private final By by_username=By.name("txtUserName");
	private final By by_password=By.name("txtPassword");
	private final By by_signin=By.name("Submit");
	private final By by_welcomepage=By.xpath("//*[@id=\"option-menu\"]/li[1]");
	
	
	public void login()
	{
		try {
			
			CommonUtils.enterValue(getUsername(), "selenium", true);
			CommonUtils.enterValue(getPassword(), "selenium", true);
			CommonUtils.clickElement(getSignIn());
		}catch(Exception e) {
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
//Getter functions
	public By getUsername()  {
		return by_username;	
	}
	public By getPassword()  {
		return by_password;
	}
	public By getSignIn() {
		return by_signin;
	}
	public By getWelcomePage() {
		return by_welcomepage;
	}

}
