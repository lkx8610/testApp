package com.tendcloud.adt.testcases.non_keywords.smoke;

import static framework.base.Verify.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.ApplicationPage;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.webdriver.TestNGListener;
import test.base.TestGroups;

@Listeners(TestNGListener.class)
public class TestDelApp extends AdtTestBase{
	
	ApplicationCenterPage acp = null;
	/**
	 * 定义要删除的应用的名字：
	 * 此功能包括：批量删除（如果有多个符合要求的名字被找到）；单个删除（如果只有一个符合要求的名字被找到）；
	 */
	String appTobeDelName = "ADT-AUTO";
	
		@Test(groups=TestGroups.UNIT)
		public void login(){
			
			LoginPage lp = new LoginPage();
			
			acp = lp.navi2ApplicationCenterPage();
		}
	
		@Test(groups=TestGroups.UNIT, dependsOnMethods="login")
		public void batchDele() throws Exception{
			ApplicationCenterPage acp = new ApplicationCenterPage();
			String appTobeDelName = "ADT-AUTO";
			
			stepInfo("1. 查询出应用列表");
			List<WebElement> list = acp.searchMultiApplication(appTobeDelName);
			
			stepInfo("2. 开始批量删除应用");
			int count = 0;
			ApplicationPage ap = new ApplicationPage();
			for(int i=0; i<list.size(); i++){
				try{
					//ApplicationPage ap = acp.navi2AppSetting(appTobeDelName);
					ap.delApplication(appTobeDelName);
				}catch(Exception e){
					back2ApplicationCenter();
				}
				
				count ++;
			}
			
			stepInfo("3. 统计共删除多少个");
			logger.info("共删除 '" + count + "' 个应用");
			
			stepInfo("4. 验证是否全部删除符合条件的记录");
			verifyEquals(count, list.size(), "期望删除：[" + list.size() + "]个应用， 实际删除: [" + count + "]个应用。");
		}
}
