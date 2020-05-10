package com.orangehrmlivetestcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrmlive.pages.Home_DashboardPage;
import com.orangehrmlive.pages.LoginPanelPage;
import com.orangehrmlive.setup.DriverSetup;
import com.orangehrmlive.test.setup.BaseTests;

public class LoginPanelPageTest extends BaseTests{

	@Test
	public void validatesuccesfulloginTest() {		
		/*
		 * Home_DashboardPage homeDashboard = loginPanelPage.userLogin("Admin",
		 * "admin123"); assertTrue(homeDashboard.getWelcomeMessage().contains("Admin")
		 * ,"Usuario no realizo login con exito");
		 */
	}

	
}
