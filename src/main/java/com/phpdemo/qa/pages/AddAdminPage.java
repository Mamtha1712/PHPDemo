package com.phpdemo.qa.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.util.TestUtilities;

public class AddAdminPage extends TestBase{
	//object repository
	@FindBy(name = "fname")
	WebElement firstName;
	
	@FindBy(name="lname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailAdd;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement MobileNum;
	
	@FindBy(xpath="//a[@class='select2-choice']")
	WebElement CountryList;
	
	@FindBy(xpath="//div[@class='select2-search']//input[@type='text']")
	WebElement countrySearchTxt;
	
	@FindBy(xpath="//div[contains(@class,'panel-body')]//div[8]//div[1]//input[@name='address1']")
	WebElement Address1;
	
	@FindBy(xpath="//div[contains(@class,'panel-body')]//div[9]//div[1]//input[@name='address2']")
	WebElement Address2;
	
	@FindBy(xpath="//select[contains(@name,'status')]")
	WebElement statusList;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12')]//ins[contains(@class,'iCheck-helper')]")
	WebElement newsletterSub;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-primary')]")
	WebElement submitBtn;
	
	
	// initiate driver
	public AddAdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	public String getAddAdminPageTitle() {
		return driver.getTitle();
	}
	

	public void createAddAdmins() throws Exception, IOException {
		int rcont = TestUtilities.getRowCount("AddAdmin");
		System.out.println("row count is " +rcont);
		for (int i=1; i<=rcont; i++){
			
			String sFName = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "FirstName");
			String sLName = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "LastName");
			String semail = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Email");
			String spasswd = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Password");
			String smobNum = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "MobileNumber");
			String scountryval = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Country");
			String sAdd1 = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i,  "Address1");
			String sAdd2 = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Address2");
			String sstatus = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Status");
			String snewsLetter = TestUtilities.getTestDataFrmXcel(prop.getProperty("sheetname"), i, "Newsletter");
		
		firstName.sendKeys(sFName);
		lastName.sendKeys(sLName);
		emailAdd.sendKeys(semail);
		password.sendKeys(spasswd);
		MobileNum.sendKeys(smobNum);
		//TestUtilities.selectOptionfromList(CountryList, scountryval);
		System.out.println("country value is "+scountryval);
		driver.findElement(By.xpath("//a[@class='select2-choice']")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'select2-results')]//"
				+ "div[@class='select2-result-label'][text()='"+scountryval+"']")).click();
				
		Address1.sendKeys(sAdd1);
		Address2.sendKeys(sAdd2);
		TestUtilities.selectOptionfromList(statusList, sstatus);
		
		//if (newsletterSub.isEnabled()) {
			//newsletterSub.click();
			if(snewsLetter.equals("Y")) {
				newsletterSub.click();
			}
		//}
		Thread.sleep(2000);
		submitBtn.click();
		Thread.sleep(2000);
		
		//validate the added admin record is addedd correctly
		/*Assert.assertEquals(driver.getTitle(), "Admins Management");
		String tablePath = "//table[contains(@class,'xcrud-list table table-striped table-hover')]/tbody/tr";
		for (int itable=1; itable<rcont; itable++) {
			String fnamecheck = driver.findElement(By.xpath(tablePath +"["+itable+"]/td[3]")).getText();
			if (fnamecheck.equals(sFName)){
				Assert.assertEquals(driver.findElement(By.xpath(tablePath +"["+itable+"]/td[4]")).getText(), sLName);
				Assert.assertEquals(driver.findElement(By.xpath(tablePath +"["+itable+"]/td[5]")).getText(), semail);
			}
		}*/
		if (i<rcont & driver.getTitle().equalsIgnoreCase("Admins Management")) {
		driver.findElement(By.xpath("//form[@class='add_button']//button[@type='submit']")).click();
		}
		}
	}
	//b8cf10944e6f4da4946004527313d470
	
}
