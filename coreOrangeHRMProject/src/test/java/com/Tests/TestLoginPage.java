package com.Tests;

import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Pages.LoginPage;
import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class TestLoginPage extends BasePage {
LoginPage loginPage = new LoginPage();
	
	
	@Test(description="verify LoginPage",priority=0)
	public void verifyLoginPage() throws Exception {
			
	loginPage.login();
	CommonUtils.hardWait(5);
	TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomePage()),"Welcome selenium");
	System.out.println("verified");
	
	}


}
