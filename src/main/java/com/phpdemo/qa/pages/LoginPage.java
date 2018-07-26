package com.phpdemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.phpdemo.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
	
	//page factory or object repo
	@FindBy(xpath="//input[@name='email' and @type='text']")
	WebElement UserName;

	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submitbtn;
	
	@FindBy(xpath="//div/h2[@class = 'form-heading text-center']")
	WebElement LoginPanel;
	
	@FindBy(id = "link-forgot")
	WebElement ForgotPwdLnk;   
	
	@FindBy(xpath ="//ins[@class='iCheck-helper']")
	WebElement RememberMeChkBx;
	
	
	//Initiate find by method
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or methods
	
	public String validateLoginPagePanel() {
		return LoginPanel.getText();
	}
	
	public boolean validateForgotPasswordLink() {
		return ForgotPwdLnk.isEnabled();
	}
	
	public boolean validateRememberMeChkBx() {
		return RememberMeChkBx.isEnabled();
	}
	
	public HomePage Loginfunction(String un, String pwd) {
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		Submitbtn.click();
		return new HomePage();
	}
	
	
	
	
	
}
