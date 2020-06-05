package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kits.sit.Base_Setup.Base_Setup;
import com.qa.pages.LeavePage;
import com.qa.pages.loginPage;

public class LeavePageTest extends Base_Setup {

	loginPage login;
	LeavePage leave;
	
	public LeavePageTest() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		leave = new LeavePage();
		login = new loginPage();
		
		login.login(prop.getProperty("username1"), prop.getProperty("password1"));
	}
	
	@Test(priority=1)
	public void validateLeaveTest() {
		
		leave.validateLeavePage();
	}
	
}
