package com.phpdemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpdemo.qa.base.TestBase;

public class AdminsPage extends TestBase{
	//Web elements object repository
	@FindBy(xpath = "//ul[@id='ACCOUNTS']//child::li[1]")
	WebElement adminOptn;
	
	@FindBy(xpath="//form[@class='add_button']//button[@type='submit']")
	WebElement addBtn;
	
	
	//initiate webdriver for above elements
	public  AdminsPage() {
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	public String getAdminPageTitle() {
		return driver.getTitle();
	}
	
	public AddAdminPage clickOnAddBtn() {
		addBtn.click();
		return new AddAdminPage();
	}
	
	
	
}
