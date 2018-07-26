package com.phpdemo.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.phpdemo.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		TestUtilities.takeScreenshotAtEndOfTest();
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Trying to find alert by: ");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("found the alert by: ");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Dismissed the alert ");
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Trying to dismiss the alert: ");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Trying to navigate refresh ");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("navigate refresh is completed");
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Trying to change value of: " +element.toString());
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("value of the  "+element.toString() +"is changed");
		
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Trying to script by: " +script.trim());
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("Trying to after script "+script);
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Trying to switch window to  " +windowName);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Switched window to " +windowName);
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Trying to generate screenshot of " +target);
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("screenshot of "+screenshot+ "is generated and stored in " +target);
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Trying to get text of element: " +element);
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("text of the element "+element+"is " +text);
		
	}

	

}
