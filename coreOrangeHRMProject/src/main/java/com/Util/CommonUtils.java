package com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Pages.LoginPage;
import com.Pages.LogoutPage;
import com.Pages.PIMPage;

public class CommonUtils {
	public static Properties config;
	public static WebDriver driver;
	public static FileInputStream fis;
	
	public static void readPropertiesFile()
	{
		
		try {
			 FileInputStream fis=new FileInputStream("C:\\Users\\chama\\git\\coreOrangeHRMRepository\\coreOrangeHRMProject\\src\\main\\resources\\config.properties");
			  config=new Properties();
			  config.load(fis);
		}
		catch(Exception e)
		{
			
		}
	}
	public static WebDriver launchBrowserAndNavigateToApp()
	{
		String	browserName=config.getProperty("browser");
		try {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}else {
	
			System.out.println("Unable to launch the browser");
		}
			driver.get(config.getProperty("Url"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
 public static WebElement findElement(By by)
 {
	 WebElement element=null;
	 try {
		
		 element = driver.findElement(by);
	 
	 }catch(Exception e) {
		
		 TestNGUtility.assertFail(e.getMessage()); 
	
	 }
	 return element;
 }
 //The method is used to delete all the text in a web element(like a text box or input field)

 public static void clearWholeText(By by)
{
	try {
		findElement(by).clear();
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
} 
 public static void enterValue(By by,String value,boolean eClear)
{
	try {
		/*if(eClear)
			clearWholeText(by); */
		findElement(by).sendKeys(value);
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}

public static void clickElement(By by) {
	try {
	findElement(by).click();
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}

public static String getElementText(By by) {
	String elementText=null;
	try {

		elementText = findElement(by).getText();//	
		System.out.println(elementText);
		

	} catch (Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
	return elementText;
}


public static void hardWait(int millis) {
	try {
		Thread.sleep(millis * 2000);
	} catch (Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
}


public static void moveToElement(By by) {
	try {
		new Actions(driver).moveToElement(findElement(by)).perform();
	}	
	catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
	
}


public static void switchToFrame(By by) {
	WebElement iframe;
	try {
		iframe=driver.findElement(by);
		driver.switchTo().frame(iframe);
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
	
}

public static void switchBackToFrame() {
	try {
		driver.switchTo().defaultContent();
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());	
	}
}


public static void searchByList(By by, String text) {
	try{
		WebElement droplist=driver.findElement(by);
	Select S=new Select(droplist);
	S.selectByVisibleText(text);
}catch(Exception e) {
	TestNGUtility.assertFail(e.getMessage());
}
	
}
public static void loginWithMultipleRecordsUsingExcel(String sheetName) throws IOException 
{
	
		String excelpath=config.getProperty("excelFilePath");
		
		FileInputStream fis=new FileInputStream(excelpath);
			try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
				XSSFSheet sheet=workbook.getSheet(sheetName);
				int total_rows=sheet.getLastRowNum();
				
				for(int i=1;i<=total_rows;i++)
				{
				String username=sheet.getRow(i).getCell(1).getStringCellValue().trim();
				String password=sheet.getRow(i).getCell(2).getStringCellValue().trim();
				
				CommonUtils.hardWait(2);

				CommonUtils.clearWholeText(LoginPage.getUsername());	
				CommonUtils.enterValue(LoginPage.getUsername(), username, true);
				CommonUtils.enterValue(LoginPage.getPassword(), password, true);
				CommonUtils.clickElement(LoginPage.getSignIn());
				try {
					String title=driver.getTitle();
					if(title.equals("OrangeHRM"))
					{
						sheet.getRow(i).createCell(3).setCellValue("Login Successfull");
						System.out.println("Login Successful for "+username);
						
						CommonUtils.clickElement(LogoutPage.getLogout());
					}else {
						System.out.println("Login failed for "+username);
						
						sheet.getRow(i).createCell(3).setCellValue("Login failed");	
						CommonUtils.captureScreenshot(username);
					
					}
					
				}catch(Exception e)
				{
					TestNGUtility.assertFail(e.getMessage());
				}
				
}
				FileOutputStream fos=new FileOutputStream(excelpath);
				workbook.write(fos);
				fos.close();
			}
}
			

private static void captureScreenshot(String name) 
{
	try {
		String screenshotpath=config.getProperty("ScreenshotFilePath");
		String fileName=name+"_"+System.currentTimeMillis()+".png";
		
		File dest_file=new File(screenshotpath+fileName);
		File source_file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source_file, dest_file);
		System.out.println("Screenshot saved successfully at :"+dest_file.getAbsolutePath());
		
		
	
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}	
	
}
public static void addMultipleEmployees(String sheetname) throws Exception {
	
	try {
		
	String excelpath=config.getProperty("excelFilePath");
	FileInputStream fis=new FileInputStream(excelpath);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet(sheetname);
	
	for(int i=1;i<=sheet.getLastRowNum();i++)
	{
		String lastname=sheet.getRow(i).getCell(0).getStringCellValue().trim();
		String firstname=sheet.getRow(i).getCell(1).getStringCellValue().trim();
		
		CommonUtils.hardWait(2);
		
		CommonUtils.enterValue(PIMPage.getLastName() ,lastname,true);
		CommonUtils.enterValue(PIMPage.getFirstName() ,firstname,true);
		
		CommonUtils.clickElement(PIMPage.getSave());
		CommonUtils.clickElement(PIMPage.getBack());
		
		CommonUtils.hardWait(2);
		CommonUtils.clickElement(PIMPage.getAddButton());
		
		System.out.println("Employee added: "+firstname+" "+lastname);
	}
	
	CommonUtils.switchBackToFrame();
	CommonUtils.hardWait(2);
	CommonUtils.clickElement(LogoutPage.getLogout());
	
	}catch(Exception e) {
		TestNGUtility.assertFail(e.getMessage());
	}
	
	
}


















}