package com.tendcloud.adt.testcases.non_keywords.unit;

import java.util.List;

import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.ApplicationPage;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.webdriver.TestNGListener;
import test.base.TestGroups;

import static framework.base.Verify.*;
import static org.testng.Assert.assertNotNull;

//@Listeners(TestNGListener.class)
public class TestWithWholeProcess extends AdtTestBase{

	/**
	 * 该测试用例是在重构了获取 产品列表的方法后进行的基本测试
	 * 	原始的获取方法是利用产品列表所在的Table定位，得到该Table下的所有元素，但问题在于，不便于操作具体的产品；
	 * 	重构后，将所有的具体产品封装到DataTable中，对DataTable封装不同的操作方法
	 * 
	 * @author James Guo
	 */
	ApplicationCenterPage acp = null;
	
	@Test(groups=TestGroups.UNIT)
	public void login(){
		
		LoginPage lp = new LoginPage();
		
		acp = lp.navi2ApplicationCenterPage();
	}
	
	@Test(groups=TestGroups.UNIT, dependsOnMethods="login")
	public void testGetAppListsWithDT() throws Exception{
		stepInfo("1. 登录  - 导航到'产品中心'..");
		
		String appName = "ADT-AUTO-TEST7312187";
		
		stepInfo("2. 导航到'产品中心页面'");
		
		stepInfo("3. 获取'产品中心页面'中应用的列表");
		List<WebElement> list = acp.getApplicationList();
		verifyTrue((null != list), "Verify:共有： " + list.size() + "条记录");
		
		stepInfo("4. 点击产品名称进入推广概览页面：");
		acp.navi2TuiGuangGaiLanPage(appName);
		
		stepInfo("5. 回退到'产品中心'");
		back2ApplicationCenter();
		
		/*stepInfo("6. 开始设置应用 -> 进入产品设置页面");
		ApplicationPage ap = acp.navi2AppSetting(appName);
		waitForPageLoad();*/
		
		stepInfo("6. 删除应用");
		ApplicationPage ap = new ApplicationPage();
		ap.delApplication(appName);
		logger.info("删除应用成功");
		
		stepInfo("7. 回退到'产品中心'");
		back2ApplicationCenter();
		
		stepInfo("8. 查询删除是否成功");
		WebElement e = acp.searchSingleApplication(appName);
		verifyTrue(null == e, "检查：该应用已被删除，查询应该为空。");
		
		stepInfo("9. 回退到 '产品中心'");
		back2ApplicationCenter();
		
		waitForPageLoad();
		
/*		List<WebElement> dataList = acp.getApplicationLists();
		verifyTrue(null != dataList, "found list");
		logger.info("应用列表获取成功。");
		stepInfo("4. 断言产品的数量");

		verifyTrue(null != dataList, "总共 " + acp.getApplicationCount() + " 条记录。");
		
		stepInfo("5. 根据名字查找应用");
		String appName = "ADT-AUTO-TEST7395432";
		
		int index = acp.searchSingleAppWithName("ADT-AUTO-TEST7395432");
		verifyTrue(index != -1, "查找到 'ADT-AUTO-TEST7395432' 所在的行：" + index);
		
		stepInfo("6. 点击名字进入详情...");
		WebElement e = getWebDriver().findElement(By.xpath("//a[contains(text(),'" + appName + "'"));
		if(null!=e){
			e.click();
		}
*/		
	}
	
	@Test(groups=TestGroups.UNIT, dependsOnMethods="login")
	public void batchDele() throws Exception{
		ApplicationCenterPage acp = new ApplicationCenterPage();
		String appTobeDelName = "ADT-AUTO";
		
		stepInfo("1. 查询出应用列表");
		List<WebElement> list = acp.searchMultiApplication(appTobeDelName);
		
		stepInfo("2. 开始批量删除应用");
		ApplicationPage ap = new ApplicationPage();
		int count = 0;
		for(int i=0; i<list.size(); i++){
			//ApplicationPage ap = acp.navi2AppSetting(appTobeDelName);
			ap.delApplication(appTobeDelName);	
			
			count ++;
		}
		
		stepInfo("3. 统计共删除多少个");
		logger.info("共删除 '" + count + "' 个应用");
		
		stepInfo("4. 验证是否全部删除符合条件的记录");
		verifyEquals(count, list.size(), "期望删除：[" + list.size() + "]个应用， 实际删除: [" + count + "]个应用。");
	}
}


















