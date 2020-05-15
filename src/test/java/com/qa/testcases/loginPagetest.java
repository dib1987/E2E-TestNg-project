package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.pages.homepageDashboard;
import com.qa.pages.loginPage;

public class loginPagetest extends Base_Setup {
	
	loginPage loginp;
	homepageDashboard homepagedash;
	
	public loginPagetest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginp = new loginPage();
	}
	
	@Test(priority=1)
	public void validatelogintitletest() {
		
		String title = loginp.logintitle();
		//AssertJUnit.assertEquals(title, ".com+ User login");
		Assert.assertTrue(title.contains("OrangeHRM"), "Not matched");
	
	}
	
	
	//This is using hardcoded //
	
	
	/*@Test(priority=2)
	public void verifylogintest() throws IOException {
		
		homepagedash = loginp.login();
	}*/
	
	
	// login using value from properties file //
	
	@Test(priority=2)
	
	public void verifylogintest() {
		
		homepagedash=loginp.login(prop.getProperty("username1"), prop.getProperty("password1"));
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
