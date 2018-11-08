/*package com.tendcloud.adt.testcases.non_keywords.smoke;

import static framework.base.Verify.verifyTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.framework.util.AdtFrameworkUtil;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.ApplicationPage;
import com.tendcloud.adt.pages.application.ApplicationTypes;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.base.anotation.TestDoc;
import framework.base.dataparser.properties.PropertiesParser;
import framework.util.FrameworkUtil;
import framework.webdriver.TestNGListener;
import test.base.TestGroups;

//@Listeners(TestNGListener.class)
public class TestCreateSmallApp extends AdtTestBase {
	//创建唯一的随机应用名字：
	String smallAppName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");
	String downloadLink = FrameworkUtil.genRandomDownloadLink();
	
	PropertiesParser prop = new PropertiesParser("test-data/properties_test_data/smallApp.properties");

	@Test(groups={TestGroups.SMOKE, TestGroups.REGRESSION})
	@TestDoc(dateDocumented="2018/7/1", testCaseID="T497081",
				testObjective="Test functionality of creating Small App...")
	public void testSmallAppWithAppTypeOthers() throws Exception{
		LoginPage lp = new LoginPage();
		
		stepInfo("1. 登录、跳转到'产品中心'页面..");
		ApplicationCenterPage acp = lp.navi2ApplicationCenterPage();
		
		stepInfo("2. 检查是否有'激活'提示框 ' 如果有，选择 '下次提醒 ' ...");
		if(acp.isActivationTipShown()){
			acp.remindNextTime();
		}
		
		stepInfo("3. 点击'创建新应用'跳转到创建新应用页面...");
		ApplicationPage application = acp.navi2ApplicationPage();
		
		stepInfo("4. 选择应用类型: 其它...");
		application.selectAppType(ApplicationTypes.OTHERS);
		
		stepInfo("5. 开始创建应用....");
		String appId = prop.getPropParam("appId");//从配置文件读取相应的数据
		String appKey = prop.getPropParam("appKey");		
		application.createSmallApp(smallAppName, appId, appKey);

		stepInfo("6. 在'保存应用'页面, 输入邮箱地址接收 SDK...");
		String emailAddr = prop.getPropParam("emailAddr");//读取配置文件取数据
		application.sendSDK2Email(emailAddr);
		waitFor(10);
		
		stepInfo("7. 保存应用并重定向到'产品中心'页面...");
		application.saveApp();
		
		stepInfo("8. 在'产品中心'页面，查找新创建的应用是否创建成功...");
		WebElement appEle = acp.searchSingleApplication(smallAppName);
		
		verifyTrue(null != appEle, "新应用" + smallAppName + "创建成功，并能正确查找...");
		
	}
}
*/