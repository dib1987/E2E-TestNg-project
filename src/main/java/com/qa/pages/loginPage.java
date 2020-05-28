package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.Testdata.Testdata;

public class loginPage extends Base_Setup {
	
	//public static String Path = "C:\\work\\TestData.xls";
	//public static String SheetName ="login";
	
	
	
	
	@FindBy(xpath="//*[@id='txtUsername']")
	 WebElement username;
	
	
	
	
	@FindBy(xpath="//*[@id='txtPassword']")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id='btnLogin']")
	WebElement loginbutton;
	
	//Encapsulation concept , private variable public methods//
	
	private By uname = By.xpath("//*[@id='txtUsername']");
	private By password = By.xpath("//*[@id='txtPassword']");
	private By clicklogbutton = By.xpath("//*[@id='btnLogin']");
	
	
	// Encapsulation concept//
	//Initialize the webelement//
	
	public loginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions //
	
	public String logintitle() {
		
		return driver.getTitle();
	}
	
	// This is data driven login //
	
	/*public locationPage loginpage() throws IOException {
		
		Testdata.setExcelFile(Path, SheetName);
		userid.sendKeys(Testdata.getCelldata(1, 0));
		password.sendKeys(Testdata.getCelldata(1, 1));
		submitbutton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return new locationPage();
		
	}*/
	
	// This is login where user is hardcoded //
	// here we are using encapsulation concept, private variable and public method//
	
	/*public homepageDashboard verifylogin() {
		
		//username.sendKeys(prop.getProperty(username1));
		
		//uname.sendKeys("admin");
		driver.findElement(uname).sendKeys("admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(clicklogbutton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//pwd.sendKeys("admin123");
		
		return new homepageDashboard();
		
		
		
		
		
		
	}*/
	
	// This is login where user is retriving data from properties file //
	
     public homepageDashboard login(String un,String pd) {
    	 
    	 //username.click();
    	 
    	
		
		//username.sendKeys(un);
		
		
		
		//pwd.sendKeys(pd);
		
		//loginbutton.click();
    	 
    	 driver.findElement(uname).click();
    	 driver.findElement(uname).sendKeys(un);
    	 driver.findElement(password).sendKeys(pd);
    	 driver.findElement(clicklogbutton).click();
    	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return new homepageDashboard();
		
		
		
		
		
		
	}

}
