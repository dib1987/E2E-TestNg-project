package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.pages.homePage;
import com.qa.pages.locationPage;
import com.qa.pages.loginPage;

public class HomePageTest extends Base_Setup {
	
	locationPage loc;
	loginPage login;
	homePage homepage;
	
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws IOException, InterruptedException {
		initialization();
		login = new loginPage();
		homepage = new homePage();
		loc = new locationPage();
		login.loginpage();
		loc.verifylocation();
		
		
	}
	
	@Test(priority=1)
	public void verifyhomepagetitletest() {
		
		//String title = homepage1.verifyhomepagetitle();
		//Assert.assertEquals(title, ".com+");
		String title = homepage.verifyhomepagetitle();
		Assert.assertEquals(title, ".com+");
	}
	
	@Test(priority=2)
	public void verifyhomepagedatatitletest() {
		
		//homepage1.verifyhomepagedatatitle();
		homepage.verifyhomepagedatatitle();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
