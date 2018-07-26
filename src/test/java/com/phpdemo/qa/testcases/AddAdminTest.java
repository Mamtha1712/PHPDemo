package com.phpdemo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.pages.AddAdminPage;
import com.phpdemo.qa.pages.AdminsPage;
import com.phpdemo.qa.pages.HomePage;
import com.phpdemo.qa.pages.LoginPage;


public class AddAdminTest extends TestBase{
		LoginPage login;
		HomePage HomePage;
		AdminsPage adminPage;
		AddAdminPage addAdminPge;
		
	
	public AddAdminTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		Initialisation();
		login = new LoginPage();
		HomePage = new HomePage();
		adminPage= new AdminsPage();
		HomePage = login.Loginfunction(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(2000);
		adminPage = HomePage.clickOnAdminSubMenu();
		addAdminPge = adminPage.clickOnAddBtn();
		
	}
	
	@Test
	public void validateAddAdminPageTitleTest() {
		String pageTitle = addAdminPge.getAddAdminPageTitle();
		Assert.assertEquals(pageTitle, "Add Admin", "AddAdmin page title do not match");
	}
	
	@Test
	public void createAddAdminTest() throws Exception {
		addAdminPge.createAddAdmins();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
