package com.tendcloud.adt.testcases.non_keywords.unit;

import static framework.base.Validate.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.webdriver.TestContext;
import test.base.TestGroups;

/** 
*@description TODO 
*@author James Guo
**/
public class TestGetWebDriver {
	WebDriver driver = null;
	
	@Test(groups={TestGroups.UNIT})
	public void getWebDriver() {
		driver = TestContext.getWebDriver();
		
		validateTrue((null == driver), "WebDriver is not null");
	}
	
	@AfterTest
	public void tearDown() {
		WebDriver d = TestContext.getWebDriver();
		
		validateEquals(d, driver, null);
		driver.quit();
	}
}
