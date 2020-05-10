package com.orangehrmlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPanelPage {
	
	//public static String Path = "C:\\work\\TestData.xls";
	//public static String SheetName ="login";
	
	private final WebDriver driver; 
	
	private By userNameText = By.id("txtUsername");
	private By passwordText = By.id("txtPassword");
	private By message = By.id("spanMessage");	
	private By loginButton = By.id("btnLogin");
	
	/***
	 * 	Initialization constructor using single dependency injection
	 * @param driver - WebDriver
	 */
	public LoginPanelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/***
	 * Performs the login process
	 * @param user - user credentials
	 * @param password - secret value for user
	 * @return Page object 
	 */
	public Home_DashboardPage userLogin(String user, String password) {
		cleanAndEnterText(userNameText,user);
		cleanAndEnterText(passwordText,password);
		driver.findElement(loginButton).click();
		return new Home_DashboardPage(driver);
	}
	
	/**
	 * Support method to clear and enter text
	 * @param element that would be receiving 
	 * @param value represent the text to enter
	 */
	private void cleanAndEnterText(By element, String value) {
		WebElement webElement = driver.findElement(element);
		webElement.clear();
		webElement.sendKeys(value);		
	}	
	
}
