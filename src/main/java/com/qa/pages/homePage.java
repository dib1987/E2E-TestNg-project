package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kits.sit.Base_Setup.Base_Setup;

public class homePage extends Base_Setup {
	
	@FindBy(xpath="//span[@class='elem-block']")
	WebElement postcode;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement datatitle1;
	
	@FindBy(xpath="//a[contains(text(),'Customers')][1]")
	WebElement datatitle2;
	
	@FindBy(xpath="//a[contains(text(),'Orders')][1]")
	WebElement datatitle3;
	
	//Initializing the page object //
	
	public homePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions //
	
	public String verifyhomepagetitle() {
		
		return driver.getTitle();
	}
	
	public void verifyhomepagedatatitle() {
		
		datatitle1.isDisplayed();
		datatitle2.isDisplayed();
		datatitle3.isDisplayed();
	}

	
	
	
	

}
