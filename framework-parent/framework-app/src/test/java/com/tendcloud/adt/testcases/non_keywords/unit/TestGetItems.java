package com.tendcloud.adt.testcases.non_keywords.unit;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;

import framework.base.Verify;
import framework.webdriver.TestNGListener;

@Listeners(TestNGListener.class)
public class TestGetItems extends AdtTestBase{
	String id = "id=aaa";
	String xpath = "xpath = //div[@class='aaabbb']";

	
	@Test
	public void testGetItem() throws Exception{
		WebElement idVal = getElement(id);
		Verify.verifyTrue(null == idVal, "");
	}
	
	@Test
	public void testGetItems() throws Exception{
		List<WebElement> eleList = getElements(xpath);
		Verify.verifyTrue("".equals(eleList), "");
	}
}
