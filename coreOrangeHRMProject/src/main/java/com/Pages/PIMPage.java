package com.Pages;

import org.openqa.selenium.By;

import com.Util.CommonUtils;

public class PIMPage {
	
	private final static By by_pim=By.xpath("/html/body/div[4]/ul/li[2]/a/span");
	private final static By by_employee_list=By.xpath("/html/body/div[4]/ul/li[2]/ul/li[1]/a/span");
	private final static By by_add_employee=By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span");
	private final static By by_back_button=By.className("backbutton");
	private final static By by_frame=By.xpath("//iframe[@id='rightMenu']");
	private final static By by_lastname=By.id("txtEmpLastName");
	private final static By by_firstname=By.xpath("//input[@id='txtEmpFirstName']");
	private final static By by_browse=By.xpath("//*[@id=\"photofile\"]");
	private final static By by_save=By.id("btnEdit");
	private final static By by_pim_addEmp=By.xpath("/html/body/form/div/div[1]/div[2]/div[1]/h2");
	private final static By by_empname=By.xpath("//*[@id=\"standardView\"]/table/tbody/tr/td[3]/a");
	private final static By by_emp_info=By.xpath("/html/body/div/div[2]/form/div[1]/h2");
	private final static By by_search_by=By.id("loc_code");
	private final static By by_search_for=By.id("loc_name");
	private final static By by_search=By.className("plainbtn");
	private final static By by_addbutton=By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[1]");

	public static void clickOnElement() throws Exception {
		CommonUtils.clickElement(getPim());
	}
	
	
	public static By getPim() throws Exception{
		return by_pim;
	}
	public  By getEmployeeList() {
		return by_employee_list;
	}

	public static  By getAddEmployee() {
		return by_add_employee;
	}
	public static  By getBack() {
		return by_back_button;
	}
	public static By getFrame() {
		return by_frame;
	}
	
	public static  By getLastName() {
		return by_lastname;	
	}
	public static  By getFirstName() {
		return by_firstname;
	}
	
	public By getBrowse() {
		return by_browse;
	}
	public static  By getSave() {
		return by_save;
	}
	public static  By getAddEmpText() {
		return by_pim_addEmp;
	}
	public  By getEmpName() {
		return by_empname;
	}	
	public By getEmpInfo() {
		return by_emp_info;
	}
	
	public By getSearch() {
		return by_search;
	}

	public By getSearchFor() {
		
		return by_search_for;
	}
	public By getSearchBy() {
		return by_search_by;
	}
	
	public static By getAddButton() {
		return by_addbutton;
	}
	
	
	
	
	
	
	
	
	
}
