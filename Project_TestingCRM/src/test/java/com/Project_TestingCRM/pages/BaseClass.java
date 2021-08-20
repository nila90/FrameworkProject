package com.Project_TestingCRM.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Project_TestingCRM.Utility.Browserfactory;
import Project_TestingCRM.Utility.Configuration;
import Project_TestingCRM.Utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public LoginPage objLoginPage;
	public Configuration objconfiguration;

	@BeforeSuite()

	public void setUp() {

	objconfiguration = new Configuration();

	}

	@BeforeClass

	public void ApplicationOpen() {

		//driver = Browserfactory.startApplication(driver, "Chrome",
		//"https://classic.crmpro.com/index.html");

	driver = Browserfactory.startApplication(driver,objconfiguration.getBrowser(),
		objconfiguration.getBrowserUrl());

	}

	@AfterMethod

	public void checkResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			Helper.takingScreenshot(driver);

		}
		else {
			
			System.out.println("Screenshot not captured");
		}
		
	}

	@AfterClass

	public void tearDown() {

		Browserfactory.quitBrowser(driver);
	}

}
