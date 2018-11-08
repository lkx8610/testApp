package com.tendcloud.adt.testcases.non_keywords.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.TuiGuanHuoDongPage;
import com.tendcloud.adt.pages.common.LoginPage;
import com.tendcloud.adt.widgets.LeftSideBar;

import framework.base.anotation.TestDoc;
import framework.webdriver.TestNGListener;
import test.base.TestGroups;

//@Listeners(TestNGListener.class)
public class TestBasicTuiGuanHuoDong extends AdtTestBase{

	@Test(groups=TestGroups.SMOKE)
	@TestDoc(dateDocumented="2018/7/4", testObjective="basic test for TuiGuangHuoDong")
	public void testBasicTGHD() throws Exception{
		stepInfo("1. 登录..");
		ApplicationCenterPage acp = new LoginPage().navi2ApplicationCenterPage();
		
		stepInfo("2. 搜索应用...");
		WebElement e = acp.searchSingleApplication("ADT-AUTO-TEST74161154");
		e.findElement(By.xpath("//table/tbody/tr[@class='ng-scope']/td/a")).click();;
		logger.debug("xxxxx");
		
		stepInfo("3. 选择推广活动...");
		String locator = LeftSideBar.TUIGUANGHUODONG.name;
		getWebDriver().findElement(By.xpath(locator)).click();
		
		
	}
}
