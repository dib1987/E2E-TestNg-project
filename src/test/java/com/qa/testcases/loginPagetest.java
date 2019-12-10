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
import com.qa.pages.homePage;
import com.qa.pages.locationPage;
import com.qa.pages.loginPage;

public class loginPagetest extends Base_Setup {
	
	loginPage login;
	locationPage locationpage;
	
	public loginPagetest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login = new loginPage();
	}
	
	@Test(priority=1)
	public void validatelogintitletest() {
		
		String title = login.logintitle();
		AssertJUnit.assertEquals(title, ".com+ User login");
	
	}
	
	
	
	@Test(priority=2)
	public void verifylogintest() throws IOException {
		
		locationpage = login.loginpage();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
