package com.orangehrmlive.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_DashboardPage {
	
	private	WebDriver driver;
	private By welcomeUser = By.id("welcome");	
	
	public Home_DashboardPage(WebDriver _driver) {
		this.driver = _driver;
	}		
	
	public String getWelcomeMessage() {
		return driver.findElement(welcomeUser).getText();
	}

}
