package com.Pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class LoginPage {
public static Properties properties;
	
	//Web locators
	private final static By by_username=By.name("txtUserName");
	private final static By by_password=By.name("txtPassword");
	private final static By by_signin=By.name("Submit");
	private final static By by_welcomepage=By.xpath("//*[@id=\"option-menu\"]/li[1]");
	
	
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
	public static By getUsername()  {
		return by_username;	
	}
	public static By getPassword()  {
		return by_password;
	}
	public static By getSignIn() {
		return by_signin;
	}
	public static By getWelcomePage() {
		return by_welcomepage;
	}

}
