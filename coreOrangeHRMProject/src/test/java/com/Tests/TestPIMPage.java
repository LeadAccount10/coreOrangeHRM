package com.Tests;

import org.testng.annotations.Test;

import com.Base.BasePage;
import com.Pages.LoginPage;
import com.Pages.LogoutPage;
import com.Pages.PIMPage;
import com.Util.CommonUtils;
import com.Util.TestNGUtility;

public class TestPIMPage extends BasePage {
static LoginPage loginPage=new LoginPage();
static PIMPage pimpage=new PIMPage();
LogoutPage logout=new LogoutPage();	
	
@Test(description="Verify that an employee can be added successfully",enabled=false,priority=0)
	
	public void addEmployeeThenVerify() throws Exception  {
	//Log in to the application using the login page method
		loginPage.login();
		TestNGUtility.assertTrue(CommonUtils.getElementText(LoginPage.getWelcomePage()),"Welcome selenium");
		
		CommonUtils.moveToElement(PIMPage.getPim());
		CommonUtils.hardWait(2);
		CommonUtils.clickElement(pimpage.getAddEmployee());
		
		CommonUtils.switchToFrame(pimpage.getFrame());
		CommonUtils.hardWait(2);
		TestNGUtility.assertTrue(CommonUtils.getElementText(pimpage.getAddEmpText()), "PIM : Add Employee");
		CommonUtils.hardWait(2);
		
		CommonUtils.enterValue(PIMPage.getLastName(), "Chamanthi", true);
		CommonUtils.hardWait(2);
		
		CommonUtils.enterValue(PIMPage.getFirstName(), "DSU", true);
		
		CommonUtils.hardWait(2);
		
		CommonUtils.clickElement(PIMPage.getSave());
		
		CommonUtils.clickElement(PIMPage.getBack());
		CommonUtils.switchBackToFrame();
		CommonUtils.hardWait(2);
		CommonUtils.clickElement(LogoutPage.getLogout());
		}


@Test(description="Verify that the search functionality returns the correct employee",enabled=false,priority=1)
public void searchEmployee() throws Exception
{
	
	loginPage.login();
	
	CommonUtils.hardWait(2);
	CommonUtils.moveToElement(PIMPage.getPim());
	CommonUtils.clickElement(pimpage.getEmployeeList());
	
	CommonUtils.switchToFrame(pimpage.getFrame());
	CommonUtils.hardWait(2);
	TestNGUtility.assertTrue(CommonUtils.getElementText(pimpage.getEmpInfo()), "Employee Information");
	CommonUtils.searchByList(pimpage.getSearchBy(), "Emp. First Name");
	
	CommonUtils.enterValue(pimpage.getSearchFor(), "Sahasra", true);
	CommonUtils.clickElement(pimpage.getSearch());
	
	CommonUtils.switchBackToFrame();
	CommonUtils.clickElement(LogoutPage.getLogout());
			
}



@Test(description="Add multiple employees using excel and verify",enabled=true,priority=2)
public static void addMultipleEmployeesUsingExcel() throws Exception
{
	
	loginPage.login();
	TestNGUtility.assertTrue(CommonUtils.getElementText(LoginPage.getWelcomePage()),"Welcome selenium");
	
	CommonUtils.hardWait(2);
	CommonUtils.moveToElement(PIMPage.getPim());
	CommonUtils.hardWait(2);
	CommonUtils.clickElement(PIMPage.getAddEmployee());
	
	CommonUtils.switchToFrame(PIMPage.getFrame());
	CommonUtils.hardWait(2);
	TestNGUtility.assertTrue(CommonUtils.getElementText(PIMPage.getAddEmpText()), "PIM : Add Employee");
	CommonUtils.hardWait(2);
	
	
	CommonUtils.addMultipleEmployees("AddMultipleEmployees");
	
}




}



