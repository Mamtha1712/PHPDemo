package com.phpdemo.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.pages.HomePage;
import com.phpdemo.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
	LoginPage login;
	HomePage Homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		Initialisation();
		login= new LoginPage();
	}

	@Test(priority = 4)
	public void LoginPageFrgtPwdTest() {
		boolean bvalue = login.validateForgotPasswordLink();
		Assert.assertTrue(bvalue);
	} 
	
	@Test(priority = 2)
	public void LoginPagePanelTest() {
		String sValue = login.validateLoginPagePanel();
		System.out.println("print statement and value is "+sValue);
		Assert.assertEquals(sValue, "LOGIN PANEL");;
	}
	
	
	@Test(priority = 3)
	public void LoginTest() {
		Homepage = login.Loginfunction(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void RememberMeChkTest() {
		boolean remChkBx = login.validateRememberMeChkBx();
		Assert.assertTrue(remChkBx);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
