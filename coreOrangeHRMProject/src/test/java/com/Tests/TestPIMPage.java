package com.Tests;

import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Pages.LoginPage;
import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class TestPIMPage extends BasePage {
LoginPage loginPage=new LoginPage();
	
	@Test(description="Verify that an employee can be added successfully",enabled=true,priority=0)
	
	public void addEmployeeThenVerify()  {
	//Log in to the application using the login page method
		loginPage.login();
		
	TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomePage()),"Welcome selenium");
	}
	
	
}
