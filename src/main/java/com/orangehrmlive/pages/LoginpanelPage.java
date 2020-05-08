package com.orangehrmlive.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.orangehrmlive.setup.Base_Setup;

public class LoginpanelPage {
	
	
	//public static String Path = "C:\\work\\TestData.xls";
	//public static String SheetName ="login";
	
	private final WebDriver driver; 
	
	private By userName1 = By.xpath("//*[@id='txtUsername']");
	private By password1 = By.id("");
	private By errorMessage1 = By.id("");
	private By invalidDetails1 = By.xpath("");
	private By loginButton1 = By.xpath("");
	
	/*@FindBy(xpath="//*[@id='txtUsername']")
	WebElement UserName;*/
	
	/*@FindBy(xpath="//*[@id='txtPassword']")
	WebElement Password1;
	
	@FindBy(xpath="//*[@id='spanMessage']")
	WebElement Errormessage1;
	
	@FindBy(xpath="//*[@id='spanMessage']")
	WebElement Invaliddetails1;*/
	
	/*@FindBy(xpath="//*[@id='btnLogin']")
	WebElement loginbutton1;*/
	
	
	//Initialize web element//
	
	public LoginpanelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions declaration //
	
	public void verify_message_Blank_Details() {
		
		
		driver.findElement(loginButton1).click();
		
		String actualmsg = driver.findElement(errorMessage1).getText();
		System.out.println(actualmsg);
		String expectedmsg = "Username cannot be empty";
		assertTrue(actualmsg.contains(expectedmsg),"message not matched");	
	}
	
	public void verify_succesfull_login() {
    	driver.findElement(userName1).sendKeys("admin");
    	driver.findElement(password1).sendKeys("admin123");
    	driver.findElement(loginButton1).click();

	}
	
	//	Home page is the landing page so this method should return home page class object
    /*public Home_DashboardPage verify_succesfull_login() {
    	driver.findElement(userName1).sendKeys("admin");
    	driver.findElement(password1).sendKeys("admin123");
    	driver.findElement(loginButton1).click();
		return new Home_DashboardPage(driver);
	}*/
}
