package com.freecrm.qa.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase

{
	LoginPage login;
	SoftAssert soft;
	HomePage homepage;
	
	//Constructer
	public LoginPageTest()
	{
		super();
	}
	
	//TestCases
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login=new LoginPage();
		soft=new SoftAssert();
		
		
	}
	
/*	@Test(priority=1)
	public void VerifyLoginTitleTest()
	{
		String Title=login.VerifyLoginTitle();
		soft.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", Title);
		
	}*/
	

	@Test(priority=2)
	public void LoginApplicationTest()
	{
		login.LoginApplication(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
