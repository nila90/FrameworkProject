package com.Project_TestingCRM.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Project_TestingCRM.pages.BaseClass;
import com.Project_TestingCRM.pages.LoginPage;

public class smoketests extends BaseClass {

	@Test
	public void checkLogin() {

		objLoginPage = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertEquals(objLoginPage.checkLogin("testing90", "Abcd@123456"), true);

	}

}
