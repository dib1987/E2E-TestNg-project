package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.pages.homePage;
import com.qa.pages.locationPage;
import com.qa.pages.loginPage;

public class locationpagetest extends Base_Setup {
	
	locationPage loc;
	loginPage login;
	homePage homepage;
	
	public locationpagetest() {
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization();
		loc = new locationPage();
		login = new loginPage();
		login.loginpage();
	}
	
	@Test(priority=1)
	public void verifylocationpagetitletest() {
		
		String title = loc.locationpagetitle();
		AssertJUnit.assertEquals(title, ".com+ Select your location");
	}
	
	@Test(priority=2)
	public void verifylocationpagetest() throws InterruptedException, IOException {
		
		//login.loginpage();
		homepage = loc.verifylocation();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}