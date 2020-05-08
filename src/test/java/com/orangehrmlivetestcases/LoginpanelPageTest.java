package com.orangehrmlivetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrmlive.pages.Home_DashboardPage;
import com.orangehrmlive.pages.LoginpanelPage;
import com.orangehrmlive.setup.Base_Setup;

public class LoginpanelPageTest {

	private WebDriver driver;
	protected LoginpanelPage login;
	protected Home_DashboardPage homepage;

	/*public LoginpanelPageTest() {

		super();
	}*/

	@BeforeMethod
	public void setup() {
		driver = new Base_Setup().driver;
		/*initialization();*/
		login = new LoginpanelPage(driver);
	}

	/*@Test(priority = 1)
	public void validateErrormessageTest() {

		login.verify_message_Blank_Details();
	}*/

	@Test
	public void validatesuccesfulloginTest() {

		login.verify_succesfull_login();
	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

	/*public Home_DashboardPage verify_succesfull_login() {
	    	driver.findElement(userName1).sendKeys("admin");
	    	driver.findElement(password1).sendKeys("admin123");
	    	driver.findElement(loginButton1).click();
			return new Home_DashboardPage(driver);
		}*/

}
