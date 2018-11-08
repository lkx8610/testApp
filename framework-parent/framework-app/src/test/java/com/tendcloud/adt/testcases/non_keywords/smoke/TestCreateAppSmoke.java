/*package com.tendcloud.adt.testcases.non_keywords.smoke;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;
import com.tendcloud.adt.framework.constants.BasicTestConstants;
import com.tendcloud.adt.framework.util.AdtFrameworkUtil;
import com.tendcloud.adt.pages.application.AppPlatformsType;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.ApplicationPage;
import com.tendcloud.adt.pages.application.ApplicationTypes;
import com.tendcloud.adt.pages.application.ApplicationPage.ApplicationStatus;
import com.tendcloud.adt.pages.common.LoginPage;

import framework.base.Verify;
import framework.base.anotation.TestDoc;
import framework.base.utils.PerformanceTimer;
import framework.util.FrameworkUtil;
import framework.webdriver.TestContext;
import framework.webdriver.TestNGListener;
import test.base.TestGroups;

@Listeners(TestNGListener.class)
public class TestCreateAppSmoke extends AdtTestBase {
	ApplicationCenterPage acp = new ApplicationCenterPage();
	
	@Test(groups={TestGroups.SMOKE, TestGroups.REGRESSION})
	@TestDoc(testObjective="先决条件：登录。。。")
	public void login(){
		
		stepInfo("precondition. 登录、跳转到 产品中心 页面...");
		LoginPage lp = new LoginPage();
		acp = lp.navi2ApplicationCenterPage();
	}
	
	@Test(groups = TestGroups.SMOKE, dependsOnMethods="login")
	@TestDoc(testCaseID="C92326", testObjective="创建应用： '电商' -  'iOS' - '开发中'")
	public void testCreateNewAppEcommertialIOS() throws Exception {
		PerformanceTimer timer = new PerformanceTimer();//创建计时器
		
		String appName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");//随机生成应用名称；
		
		stepInfo("1. 判断是否有 激活提醒 的弹出框，如果有，选择 下次提醒...");
		//判断激活提示框是否出现，如出现，选择下次提醒,有时定位不了，暂时去除这个，设置为“不再提醒”： TODO
		if(acp.isActivationTipShown()){
			acp.remindNextTime();
		}
		
		stepInfo("step 2. 点击 '创建新应用按钮...");
		acp.navi2ApplicationPage();//在Application Center Page上点“创建新应用”进入Application页面；

		logger.info("等待页面加载完成: " + TestContext.getDomTimeout());
		waitFor(TestContext.getDomTimeout());
		
		ApplicationPage application = new ApplicationPage();	
		
		stepInfo("step 3. 选择应用类型：电商..");
		application.selectAppType(ApplicationTypes.ECOMERCIAL);
		
		stepInfo("step 4. 开始创建新应用...");
		application.createNewApp(appName, AppPlatformsType.IOS, ApplicationStatus.DEVELOPING , null);
		
		stepInfo("step 5. 在 保存应用 页面, 输入接收 SDK 的邮箱地址...");
		application.sendSDK2Email(BasicTestConstants.RECEIVE_SDK_EAMIL_ADDR);
		waitFor(10);

		stepInfo("step 6. 点击 保存 按钮....");
		application.saveApp();
		
		stepInfo("step 7. 检查是否创建成功...");
		waitFor(300);
		
		searchAndVerify(appName);
		
		//添加完成后再次回到产品中心页面，此时，如果有激活提示框，则“下次提醒”：
		if(acp.isActivationTipShown()){
			acp.remindNextTime();
		}
		
		logger.info(timer.getElapsedTimeString());
	}
	
	@Test(groups=TestGroups.SMOKE, dependsOnMethods="login")
	@TestDoc(testObjective="创建新应用：电商 - Android - 已上架")
	public void testCreateAppEcommertialAndroid() throws Exception{
		PerformanceTimer timer = new PerformanceTimer();//创建计时器
		String appName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");//随机生成应用名称；
		
		stepInfo("1. 判断是否有 激活提醒 的弹出框，如果有，选择 下次提醒...");
		
		stepInfo("step 2. 点击 '创建新应用按钮...");
		ApplicationPage application = acp.navi2ApplicationPage();//在Application Center Page上点“创建新应用”进入Application页面；

		logger.info("等待页面加载完成: " + TestContext.getDomTimeout());
		waitFor(TestContext.getDomTimeout());
		
		stepInfo("step 3. 选择应用类型：电商..");
		application.selectAppType(ApplicationTypes.ECOMERCIAL);
		
		stepInfo("step 4. 开始创建新应用...");
		application.createNewApp(appName, AppPlatformsType.ANDROID, ApplicationStatus.ONSTOR , FrameworkUtil.genRandomDownloadLink());
		
		stepInfo("step 5. 在 保存应用 页面, 输入接收 SDK 的邮箱地址...");
		application.sendSDK2Email(BasicTestConstants.RECEIVE_SDK_EAMIL_ADDR);
		waitFor(10);

		stepInfo("step 6. 点击 保存 按钮....");
		application.saveApp();
		
		searchAndVerify(appName);
		
		logger.info(timer.getElapsedTimeString());
	}
	
	@Test(groups=TestGroups.SMOKE, dependsOnMethods="login")
	@TestDoc(testCaseID="C92328", testObjective="创建应用，选择其他平台，H5类型 - 已上架")
	public void testCreateAppEcommertialH5() throws Exception{
		PerformanceTimer timer = new PerformanceTimer();//创建计时器
		String appName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");//随机生成应用名称；
		
		stepInfo("1. 判断是否有 激活提醒 的弹出框，如果有，选择 下次提醒...");
		stepInfo("step 2. 点击 '创建新应用按钮...");
		acp.navi2ApplicationPage();//在Application Center Page上点“创建新应用”进入Application页面；

		logger.info("等待页面加载完成: " + TestContext.getDomTimeout());
		waitFor(TestContext.getDomTimeout());
		
		ApplicationPage application = new ApplicationPage();	
		
		stepInfo("step 3. 选择应用类型：其它..");
		application.selectAppType(ApplicationTypes.OTHERS);
		
		stepInfo("step 4. 开始创建新应用...");
		application.createNewApp(appName, AppPlatformsType.ANDROID, ApplicationStatus.ONSTOR , FrameworkUtil.genRandomDownloadLink());
		
		stepInfo("step 5. 在 保存应用 页面, 输入接收 SDK 的邮箱地址...");
		application.sendSDK2Email(BasicTestConstants.RECEIVE_SDK_EAMIL_ADDR);
		waitFor(10);

		stepInfo("step 6. 点击 保存 按钮....");
		application.saveApp();
		
		searchAndVerify(appName);
		
		logger.info(timer.getElapsedTimeString());
	}
	
	public void searchAndVerify(String appName) throws Exception{
		WebElement e = acp.searchSingleApplication(appName);
		
		Verify.verifyTrue(null != e, "'" + appName + "' 搜索结果不能为空");
	}
}









*/