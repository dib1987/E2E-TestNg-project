package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kits.sit.Base_Setup.Base_Setup;

public class homepageDashboard extends Base_Setup {
	
	
	@FindBy(xpath="//input[@id='location']")
	WebElement location;
	
	@FindBy(xpath="//input[@id='confirmLocation']")
	WebElement confirmbutton;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
	WebElement dashboard1;
	
	
	private By dashboard =By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
	
	
	// Initializing the Page object //
	
	public homepageDashboard() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions//
	
	public String dashboardpagetitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyDashboardPage() {
		
		return driver.findElement(dashboard).isDisplayed();
	}

}
