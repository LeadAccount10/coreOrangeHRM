package com.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Pages.LoginPage;
import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class TestLoginPage extends BasePage {
LoginPage loginPage = new LoginPage();
	
	
	@Test(description="verify LoginPage",enabled=false,priority=0)
	public void verifyLoginPage() throws Exception {
			
	loginPage.login();
	CommonUtils.hardWait(5);
	TestNGUtility.assertTrue(CommonUtils.getElementText(LoginPage.getWelcomePage()),"Welcome selenium");
	System.out.println("verified");
	
	}


	@Test(description="verify the login page with multiple login functionality",enabled=true,priority=1)
	public void multipleLogin() throws IOException
	{
		CommonUtils.loginWithMultipleRecordsUsingExcel("MultipleLoginFunctionality");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
