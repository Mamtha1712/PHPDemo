package com.phpdemo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.pages.HomePage;
import com.phpdemo.qa.pages.LoginPage;
import com.phpdemo.qa.pages.QuickBookingsPage;

public class QuickBookingPageTest extends TestBase {
	HomePage homepage;
	QuickBookingsPage QCKBKpage;
	LoginPage login;
	
	public QuickBookingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialisation();
		login = new LoginPage();
		QCKBKpage = new	QuickBookingsPage();
		homepage = new HomePage();
		login.Loginfunction(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	
	
	
	@Test
	public void setCheckinDateTest() throws Exception {
		Thread.sleep(3000);
		homepage.clickOnQuickBookNvalidateHeader();
		Thread.sleep(2000);
		homepage.enterQuickBookingDetails("Yes", "Flights");
		QCKBKpage.clickonCheckinDateField();
		QCKBKpage.SetCheckInDate("15/08/2020");
	}
	
	@AfterMethod
	public void teardown() {
		//driver.quit();
	}
	

}
