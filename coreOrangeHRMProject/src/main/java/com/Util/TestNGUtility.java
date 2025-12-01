package com.Util;

import org.testng.Assert;

public class TestNGUtility {
	
public static void assertTrue(String actual,String expected) {
		
		if(actual.contains(expected)) {
			
			Assert.assertTrue(actual.contains(expected));
			
		}
		else {
			
			System.out.println(expected+" "+"not present in"+" "+actual);
		
		}
	}
	public static void assertFail(String logMessage) {

		Assert.fail(logMessage);
	}
}
