package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.pages.homepageDashboard;
import com.qa.pages.loginPage;

public class homepageDashboardtest extends Base_Setup {
	
	
	loginPage login;
	homepageDashboard homedashboard;
	
	public homepageDashboardtest() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		homedashboard=new homepageDashboard();
		login = new loginPage();
		login.login(prop.getProperty("username1"), prop.getProperty("password1"));
		
		
		
	}
	
	@Test(priority=1)
	public void validateDashboardPagetitletest() {
		
		String title = homedashboard.dashboardpagetitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "page title doesnt match");
	}
	
	@Test(priority=2)
	public void validateDashboardPageTexttest() {
		
		homedashboard.verifyDashboardPage();
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	

}
