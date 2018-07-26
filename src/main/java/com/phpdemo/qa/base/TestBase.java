package com.phpdemo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.phpdemo.qa.util.TestUtilities;
import com.phpdemo.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
				
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\mamtha\\Selenium Practice\\eclipse\\Demosite\\src\\main\\java\\com\\phpdemo\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialisation() {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\mamtha\\Selenium Practice\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\mamtha\\Selenium Practice\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//event listener initiation
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;	
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.Page_Load_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URLlink"));
		
	}
	
	
}
