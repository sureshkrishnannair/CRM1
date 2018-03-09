package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 

{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {

			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:/Users/suresh/workspace1/CRM/src/main/java/com/crm/qa/config/config.properties");

			prop.load(ip);

		} catch (FileNotFoundException e){

			e.printStackTrace();

		} catch (IOException e)	{

			e.printStackTrace();

		}

	}
		
	//initialization
	
	public static void initialization()
	{
String browserName = prop.getProperty("browser");

		

		if(browserName.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "C:/Suresh/Selenium Configuration/chromedriver.exe");	
			
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars");

			driver = new ChromeDriver(options); 

		}

		else if(browserName.equals("FF")){

			System.setProperty("webdriver.gecko.driver", "C:/Suresh/Selenium Configuration/geckodriver.exe");	

			driver = new FirefoxDriver(); 

		}
		
		else if(browserName.equals("IE")){

			System.setProperty("webdriver.ie.driver", "C:/Suresh/Selenium Configuration/IEDriverServer.exe");	

			driver = new InternetExplorerDriver(); 

		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
