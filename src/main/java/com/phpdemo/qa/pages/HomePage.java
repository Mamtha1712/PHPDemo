package com.phpdemo.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.phpdemo.qa.base.TestBase;

public class HomePage extends TestBase {
	//Page factory or object repository
	@FindBy(xpath="//div[contains(text(),'Booking Summary')]")
	WebElement landingPageHeader;
	
	@FindBy(xpath ="//a[@class='btn btn-success btn-sm btn-block']")
	WebElement profileBtn;
	
	@FindBy(xpath="//a[@class='btn btn-danger btn-sm btn-block']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//div[@class='social-sidebar-content']/div[6]/div[1]/ul[1]/li[5]")
	WebElement accountsMenu;
	
	@FindBy(id = "sidebar-query")
	WebElement searchbx;
	
	@FindBy (xpath="//ul[@id='ACCOUNTS']")
	WebElement accountsOptns;
	
	@FindBy(xpath = "//ul[@id='ACCOUNTS']//child::li[1]")
	WebElement adminOptn;
	
	//initiate the driver and find by
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public String validateProfileBtnPresent() {
		return profileBtn.getText();
	}
	
	public void ProfileBtnClick() {
		profileBtn.click();;
	}
	
	public String validateLogoutBtnPresent() {
		return logoutBtn.getText();
	}
	
	public void LogoutBtnClick() {
		logoutBtn.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnAccountsMenu() {
		accountsMenu.click();
	}
	
	public List <WebElement> getAllSubMenuOptns() {
		List <WebElement> optns = driver.findElements(By.xpath("//ul[@id='ACCOUNTS']//child::li"));
		System.out.println(optns.size());
		
		return optns;
	}
	
	public AdminsPage clickOnAdminSubMenu() {
		accountsMenu.click();
		adminOptn.click();
		return new AdminsPage();
	}
}
