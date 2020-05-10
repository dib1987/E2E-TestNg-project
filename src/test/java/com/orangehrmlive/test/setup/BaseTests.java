package com.orangehrmlive.test.setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangehrmlive.pages.Home_DashboardPage;
import com.orangehrmlive.pages.LoginPanelPage;
import com.orangehrmlive.setup.DriverSetup;

public class BaseTests {
	
	private WebDriver driver;
	
	protected Home_DashboardPage home_DashboardPage;
	protected LoginPanelPage loginPanelPage;

	
	 @BeforeClass 
	 public void setup() { 
		 driver = new DriverSetup().getDriver();
		 loginPanelPage = new LoginPanelPage(driver); 
	  }
	  
	 @AfterClass 
	 public void teardown(){ 
		 driver.quit(); 
	}
	 
}
