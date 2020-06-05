package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.kits.sit.Base_Setup.Base_Setup;

public class LeavePage extends Base_Setup {

	
	
	
	private By LeavePage =By.xpath("//span[text()='Assign Leave']");
	private By assignLeave = By.xpath("//*[@id='assign-leave']/div[1]");
	
    public LeavePage() {
		
		PageFactory.initElements(driver, this);
	}
    
    
    public Boolean validateLeavePage() {
    	
    	driver.findElement(LeavePage).click();
    	return driver.findElement(assignLeave).isDisplayed();
    	
    	
    }
	
}
