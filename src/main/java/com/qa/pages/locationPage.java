package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kits.sit.Base_Setup.Base_Setup;

public class locationPage extends Base_Setup {
	
	
	@FindBy(xpath="//input[@id='location']")
	WebElement location;
	
	@FindBy(xpath="//input[@id='confirmLocation']")
	WebElement confirmbutton;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	// Initializing the Page object //
	
	public locationPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions//
	
	public String locationpagetitle() {
		
		return driver.getTitle();
	}
	
	public homePage verifylocation() throws InterruptedException {
		
		location.sendKeys(prop.getProperty("postcode"));
		confirmbutton.click();
		Thread.sleep(2000);
		continuebutton.click();
		
		return new homePage();
	}

}
