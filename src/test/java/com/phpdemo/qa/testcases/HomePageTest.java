package com.phpdemo.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.pages.HomePage;
import com.phpdemo.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginp;
	HomePage HomePage;
		
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		Initialisation();
		loginp = new LoginPage();
		HomePage = loginp.Loginfunction(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(2000);
	}
	//test priority 
	@Test(priority=3)
	public void validateTitlepageTest() {
		String pgeTitle = HomePage.getHomePageTitle();
		Assert.assertEquals(pgeTitle, "Dashboard");
		HomePage.LogoutBtnClick();
	}
	
	@Test(priority=2)
	public void validateProfileBtnTest() {
		String BtnText = HomePage.validateProfileBtnPresent();
		Assert.assertEquals(BtnText, "PROFILE");
	}
	
	@Test(priority=1)
	public void getAllAcctsSubMenusTest() {
		HomePage.clickOnAccountsMenu();
		List <WebElement> optns1 = HomePage.getAllSubMenuOptns();
		int suboptnscount = optns1.size();
		Assert.assertEquals(4, suboptnscount);
		
		for (WebElement ele: optns1) {
			String optnName = ele.getText();
				if (optnName == "ADMINS") {
					System.out.println("ADMINS is available");					
				} else if (optnName == "SUPPLIERS") {
					System.out.println("SUPPLIERS is available");					
				} else if (optnName == "CUSTOMERS") {
					System.out.println("CUSTOMERS is available");
				} else if (optnName == "GUESTCUSTOMERS") {
					System.out.println("GUESTCUSTOMERS is available");
				}
		}
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
