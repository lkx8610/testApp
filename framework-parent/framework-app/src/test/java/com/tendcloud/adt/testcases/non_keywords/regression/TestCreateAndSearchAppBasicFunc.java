//package com.tendcloud.adt.testcases.non_keywords.regression;
//
//import static framework.base.Verify.*;
//
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.tendcloud.adt.framework.base.AdtTestBase;
//import com.tendcloud.adt.framework.constants.BasicTestConstants;
//import com.tendcloud.adt.framework.util.AdtFrameworkUtil;
//import com.tendcloud.adt.pages.application.AppPlatformsType;
//import com.tendcloud.adt.pages.application.ApplicationCenterPage;
//import com.tendcloud.adt.pages.application.ApplicationPage;
//import com.tendcloud.adt.pages.application.ApplicationTypes;
//import com.tendcloud.adt.pages.application.ApplicationPage.ApplicationStatus;
//import com.tendcloud.adt.pages.common.LoginPage;
//
//import framework.base.anotation.TestDoc;
//import framework.base.utils.PerformanceTimer;
//import framework.util.FrameworkUtil;
//import framework.webdriver.TestNGListener;
//import test.base.TestGroups;
//
////@Listeners(TestNGListener.class)
//public class TestCreateAndSearchAppBasicFunc extends AdtTestBase {
//	
//	String applicationName;//生成随机的Application的名称，此处提出为变量，在后边查找的时候要用到。；
//	
//	@Test(groups = TestGroups.REGRESSION)
//	@TestDoc(dateDocumented="2018/6/20", testObjective="创建新应用基本测试 App_Type=ECOMERCIAL - Platform_Type=ANDROID")
//	public void testCreateApp_ECOMERCIAL() throws Exception {//App type=ECOMERCIAL
//		PerformanceTimer timer = new PerformanceTimer();//创建计时器
//		
//		LoginPage login = new LoginPage();
//
//		stepInfo("step 1. login and navigating to Applicatin Center Page...");
//		ApplicationCenterPage applicationCenterPage = login.navi2ApplicationCenterPage();
//		
//		stepInfo("step 2. press 'Create New App' button and navi to Application Page...");
//		applicationCenterPage.navi2ApplicationPage();//在Application Center Page上点“创建新应用”进入Application页面；
//
//		/*logger.info("waitting for the page to be ready: " + TestContext.getDomTimeout());
//		waitFor(TestContext.getDomTimeout());*/
//		
//		ApplicationPage application = new ApplicationPage();	
//		
//		stepInfo("step 3. select Application Type..");
//		application.selectAppType(ApplicationTypes.ECOMERCIAL);
//		
//		stepInfo("step 4. start creating New Application...");
//		applicationName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");//生成随机的Application的名称，此处提出为变量，在后边查找的时候要用到。；
//		application.createNewApp(applicationName, AppPlatformsType.ANDROID, ApplicationStatus.DEVELOPING , FrameworkUtil.genRandomDownloadLink());
//		
//		stepInfo("step 5. in 'Save Application' page, input Email address to receive SDK...");
//		application.sendSDK2Email(BasicTestConstants.RECEIVE_SDK_EAMIL_ADDR);
//		waitFor(10);
//
//		stepInfo("step 6. click Finish button to save the Application....");
//		application.saveApp();
//		
//		waitFor(500);
//		logger.info(timer.getElapsedTimeString());//此时创建新应用且保存成功；
//		
//		//查找刚才创建的Application：
//		ApplicationCenterPage cp = new ApplicationCenterPage();
//		stepInfo("step 7. start searching from Application Center Page to ensure the Application created successfully..");
//		WebElement newlyCreatedApp = cp.searchSingleApplication(applicationName);
//		//断言非空，如为空，则中断执行（用Verify硬断言）
//		verifyTrue(null != newlyCreatedApp , "new created application should be searched without null...");
//		logger.info("searched Application with name: '" + newlyCreatedApp + "'");
//	}
//	
//	//@Test(groups={TestGroups.REGRESSION}, dependsOnMethods={"testCreateApp_ECOMERCIAL"})
//	//@TestDoc(DateDocumented="2018/6/20", TestObjective="创建新应用测试 Type='Game' and Platform='iOS'")
//	public void TestCreateApp_GAME() throws Exception{
//		ApplicationCenterPage appCenterPage = new ApplicationCenterPage();
//		
//		stepInfo("1. from Application Center Page, and navigate to create new Application Page");		
//		ApplicationPage application = appCenterPage.navi2ApplicationPage();
//		
//		waitFor(500);
//		
//		stepInfo("2. in Application Teype Selection Page, select Application Type = 'Game' ");
//		application.selectAppType(ApplicationTypes.GAME);
//		
//		applicationName = AdtFrameworkUtil.generateAppName("ADT-AUTO-TEST");//生成应用的随机名称；
//		stepInfo("3. start creating New Application...");
//		application.createNewApp(applicationName, AppPlatformsType.IOS, ApplicationStatus.ONSTOR, FrameworkUtil.genRandomDownloadLink());
//		
//		//以下为重复代码，需重构或外部数据驱动：
//		stepInfo("4. in 'Save Application' page, input Email address to receive SDK...");
//		application.sendSDK2Email(BasicTestConstants.RECEIVE_SDK_EAMIL_ADDR);
//		waitFor(10);
//
//		stepInfo("5. click Finish button to save the Application....");
//		application.saveApp();
//		
//		//查找刚才创建的Application：
//		stepInfo("6. start searching from Application Center Page to ensure the Application created successfully..");
//		WebElement newlyCreatedApp = appCenterPage.searchSingleApplication(applicationName);
//		//断言非空，如为空，则中断执行（用Verify硬断言）
//		verifyTrue(null != newlyCreatedApp , "new created application should be searched without null...");
//		logger.info("searched Application with name: " + newlyCreatedApp);
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
