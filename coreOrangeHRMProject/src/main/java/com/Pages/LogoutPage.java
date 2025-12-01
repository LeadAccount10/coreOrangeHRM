package com.Pages;

import org.openqa.selenium.By;

public class LogoutPage {
	
	public final static By by_logout=By.xpath("//*[@id=\"option-menu\"]/li[3]/a");
	
	public static By getLogout() {
		return by_logout;
	}

}
