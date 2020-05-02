package com.orangehrmlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrmlive.setup.Base_Setup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginpanelPage extends Base_Setup {
	
	
	//public static String Path = "C:\\work\\TestData.xls";
	//public static String SheetName ="login";
	
	
	@FindBy(xpath="//*[@id='txtUsername']")
	WebElement UserName;
	
	@FindBy(xpath="//*[@id='txtPassword']")
	WebElement Password1;
	
	@FindBy(xpath="//*[@id='spanMessage']")
	WebElement Errormessage1;
	
	@FindBy(xpath="//*[@id='spanMessage']")
	WebElement Invaliddetails1;
	
	@FindBy(xpath="//*[@id='btnLogin']")
	WebElement loginbutton1;
	
	
	//Initialize web element//
	
	public LoginpanelPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions declaration //
	
	public void verify_message_Blank_Details() {
		
		
		loginbutton1.click();
		
		String actualmsg = Errormessage1.getText();
		System.out.println(actualmsg);
		String expectedmsg = "Username cannot be empty";
		Assert.assertEquals(actualmsg, expectedmsg,"message not matched");
		
		
		}
	
	// Home page is the landing page so this method should return home page class object //
	
    public Home_DashboardPage verify_succesfull_login() {
    	
    	UserName.sendKeys("admin");
    	
    	Password1.sendKeys("admin123");
    	
    	loginbutton1.click();
    	
    	
    	
		return new Home_DashboardPage();
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
	
	

}
