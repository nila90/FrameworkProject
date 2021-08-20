package com.Project_TestingCRM.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;

import Project_TestingCRM.Utility.Helper;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	public boolean checkLogin(String username, String Password,String actualbrowser) {

		uname.sendKeys(username);
		pass.sendKeys(Password);
		
		
        Helper.CheckElementNotCliakable(driver,actualbrowser,"//input[@value='Login']");
		        
  
		String expectedTitle = "CRMPRO - CRM software for customer relationship management, sales, and support.";

		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);

		
		if (expectedTitle.equalsIgnoreCase(actualTitle)) {

			return true;

		}

		else {

			return false;
		}
	}
}
