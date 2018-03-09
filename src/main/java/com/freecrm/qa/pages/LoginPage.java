package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase

{
	//Page Objects
	@FindBy(xpath="//input[@name='username']")
	WebElement Username_Field;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password_Field;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement Logo;
	
	//PageObject Initialization
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions--Scenarios
	
	//--Verify Title
	public String VerifyLoginTitle()
	{
		return driver.getTitle();
	}
	
	//--Verify Logo
	public boolean  VerifyLoginLogo()
	{
		return Logo.isDisplayed();
	}
	
	//--Login application
	
	public HomePage LoginApplication(String un,String Pwd)
	{
		Username_Field.sendKeys(un);
		Password_Field.sendKeys(Pwd);
		Submit.click();
		
		return new HomePage();
	}
	
	

}
