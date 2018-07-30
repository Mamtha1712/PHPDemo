package com.phpdemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.phpdemo.qa.base.TestBase;
import com.phpdemo.qa.util.TestUtilities;

public class QuickBookingsPage extends TestBase {
	
	@FindBy (xpath="//input[@id='Flights']")
	WebElement checkinDate;
	
	public  QuickBookingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods or actions
	
	public void clickonCheckinDateField() {
		checkinDate.click();
	}
	
	public void setdatevalue(String date) {
		for(int i=1; i<=6; i++) {
			for (int j=1; j<=7; j++) {
			 if(date.equals((driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr["+i+"]/td["+j+"]"))).getText())) {
				 driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr["+i+"]/td["+j+"]")).click();
			}
			}
		}
	}
	
	public void setYearValue(String year) {
		//String yearXpath = "//div[@class='datepicker dropdown-menu']//div[@class='datepicker-months']/table[1]/thead[1]/tr[1]/th[2][@colspan='5']";
		String yearXpath = "/html[1]/body[1]/div[3]/div[2]/table[1]/thead[1]/tr[1]/th[2]";
		String currentYear = driver.findElement(By.xpath(yearXpath)).getAttribute("innerText");
		System.out.println("***************************current year***********"+currentYear);
		if (currentYear.contains(year)) {
			
		}else {
			JavascriptExecutor exe = (JavascriptExecutor)driver;
			WebDriverWait wait = new WebDriverWait(driver, 20);
			exe.executeScript("argument[0].scrollIntoView(true);", (driver.findElement(By.xpath(yearXpath))));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yearXpath)));
			driver.findElement(By.xpath(yearXpath)).click();
			
		 currentYear = driver.findElement(By.xpath(yearXpath)).getText();
		 System.out.println("***************************current year take 2***********"+currentYear);
		 int yearDiffCnt = Integer.parseInt(year)-Integer.parseInt(currentYear);
		 System.out.println("*****************************************year difference is " +yearDiffCnt);
		 if (yearDiffCnt>0) {
			 for(int i=1; i<yearDiffCnt; i++) {
				 driver.findElement(By.xpath("//div[3]//div[2]//table[1]//thead[1]//tr[1]//th[3]")).click();
				String currYearSearch = driver.findElement(By.xpath(yearXpath)).getText();
				if (currYearSearch.equalsIgnoreCase(year))
					break;
			 }
		 }
		 	
		}
		
	}
	
	public void SetCheckInDate(String checkindate) {
		String arr[] = checkindate.split("/");
		String date, month, year;
		date = arr[0];
		month = arr[1];
		year = arr[2];
		System.out.println("********************date is "+date+" month is "+month+" year is "+year+"*******************************");
		//set year
		setYearValue(year);
		
		
		// set month
		String currentMonth = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).getText();
		month = TestUtilities.monthinterpret(month);
		if(currentMonth.contains(month)) {
			setdatevalue(date);	
		}else {
			driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).click();
			for (int monCnt = 1; monCnt<=12; monCnt++) {
				if(month.contains(driver.findElement(By.xpath("//div[3]//div[2]//table[1]//tbody[1]//tr[1]//td[1]/span["+monCnt+"]")).getText())) {
					driver.findElement(By.xpath("//div[3]//div[2]//table[1]//tbody[1]//tr[1]//td[1]/span["+monCnt+"]")).click();
					break;
				}
			}
			checkinDate.click();
			setdatevalue(date);
		}
	}
	
	

}
