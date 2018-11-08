package com.tendcloud.adt.testcases.non_keywords.smoke;

import static framework.base.Verify.verifyTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.base.anotation.TestDoc;
import test.base.TestGroups;

/**
 * 查找Application， 精确、模糊查找方式
 * @author James Guo
 *
 */
public class TestAppSearch extends AdtTestBase{
	
	ApplicationCenterPage acp = null;
	
	@Test
	public void loginFirst() {
		
		LoginPage lp = new LoginPage();
		
		stepInfo("login system...");
		lp.basicLogin();
	}
	
	/**
	 * 精确查找：查找单个
	 * @author James Guo
	 * @throws Exception 
	 */
	@Test(groups=TestGroups.SMOKE, dependsOnMethods="loginFirst")
	@TestDoc(dateDocumented="2018/7/3", testCaseID="T497088",
				testObjective="search application with Exactly Name.")
	public void testExactSearch() throws Exception{
		String appName = "ADT-AUTO-TEST7395432";
		acp = new ApplicationCenterPage();
		stepInfo("1. login and search a product with exactly name...");
		WebElement ele = acp.searchSingleApplication(appName);
		
		stepInfo("2. verify that, the search result must not be null, and only one element should be searched out...");
		verifyTrue(null != ele , "searched result must not be null, and only one element should be searched out.");
	}

	/**
	 * 模糊查找：可能返回1个或多个
	 * @author James Guo
	 * @throws Exception 
	 */
	@Test(groups=TestGroups.SMOKE, dependsOnMethods="loginFirst")
	@TestDoc(dateDocumented="2018/7/3", testCaseID="T497088",
				testObjective="search application with Fuzzy Name.")
	public void testFuzzySearch() throws Exception{
		List<WebElement> productList = null;
		
		String partialName = "ADT-AUTO-TEST";
		
		acp = new ApplicationCenterPage();
		
		stepInfo("1. login and search prorducts list...");
		productList = acp.searchMultiApplication(partialName);
		
		stepInfo("2. verify that, there're at least one element returned...");
		verifyTrue(null != productList, "found '" + productList.size()  + "' records...");
	}
}








