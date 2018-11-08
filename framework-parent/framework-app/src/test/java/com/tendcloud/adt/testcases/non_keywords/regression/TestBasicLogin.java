package com.tendcloud.adt.testcases.non_keywords.regression;

import static framework.base.Verify.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.base.LoggerManager;
import framework.base.anotation.TestDoc;
import framework.webdriver.TestContext;
import test.base.TestGroups;

public class TestBasicLogin extends AdtTestBase {
	private Logger logger = LoggerManager.getLogger(Thread.currentThread().getClass().getName());
	/*@BeforeClass
	@Override
	protected void start() throws Exception {
		System.out.println("........");
	}*/

	//@Test(groups={TestGroups.REGRESSION})
	@TestDoc(testObjective="test the basic functionality of the login...")
	public void testLoginWithTestBase() {
		WebDriver driver = TestContext.getWebDriver();
		verifyTrue(null != driver, "get webdriver from TestContext...");
		
		stepInfo("maximize the window...");
		driver.manage().window().maximize();
		
		stepInfo("login to the system...");
		login(TestContext.getUsername(), TestContext.getPassword());
		
		waitFor(3000);
	}
	
	@Test(groups={TestGroups.REGRESSION})
	public void testBasicLoginFuc(){
		WebDriver driver = TestContext.getWebDriver();
		verifyTrue(null != driver, "get webdriver from TestContext.");
		
		stepInfo("maximize the window...");
		driver.manage().window().maximize();
		
		stepInfo("navi to: " + TestContext.getServerUrl());
		driver.get(TestContext.getServerUrl());
		logger.debug("navigating to: " + TestContext.getServerUrl());
		
		LoginPage lp = new LoginPage();
		
		stepInfo("login to server...");
		lp.login(TestContext.getUsername(), TestContext.getPassword());
		waitFor(TestContext.getDomTimeout());
		
		stepInfo("close window and quit webdriver");
		driver.quit();
	}
}

















