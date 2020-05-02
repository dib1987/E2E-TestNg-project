package com.orangehrmlivetestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrmlive.pages.Home_DashboardPage;
import com.orangehrmlive.pages.LoginpanelPage;
import com.orangehrmlive.setup.Base_Setup;

public class LoginpanelPageTest extends Base_Setup {

	LoginpanelPage login;
	Home_DashboardPage homepage;

	public LoginpanelPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		login = new LoginpanelPage();
	}

	@Test(priority = 1)
	public void validateErrormessageTest() {

		login.verify_message_Blank_Details();
	}

	@Test(priority = 2)
	public void validatesuccesfulloginTest() {

		homepage = login.verify_succesfull_login();
	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
