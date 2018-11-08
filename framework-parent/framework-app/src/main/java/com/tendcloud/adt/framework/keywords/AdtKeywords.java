package com.tendcloud.adt.framework.keywords;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.tendcloud.adt.framework.constants.BasicElementLocators;
import com.tendcloud.adt.pages.application.AppPlatformsType;
import com.tendcloud.adt.pages.application.ApplicationCenterPage;
import com.tendcloud.adt.pages.application.ApplicationPage;
import com.tendcloud.adt.widgets.DataTable;

import framework.base.BaseFramework;
import framework.base.LoggerManager;
import framework.base.exception.StopRunningException;
import framework.base.utils.PerformanceTimer;
import framework.base.utils.ReportUtils;
import framework.keyworddriven.BaseKeywords;
import framework.util.FrameworkUtil;
import framework.webdriver.TestContext;

/**
 * 该类是ADT产品的独有关键字类，继承于BaseActionKeywords
 * 
 * @author James Guo
 */
public class AdtKeywords extends BaseKeywords {
	Logger log = LoggerManager.getLogger(this.getClass().getSimpleName());
	// 接口Excel文件的位置；
	String apiExcelFilePath = "";

	/** --------------应用CURD相关关键字开始------------- */
	/**
	 * 创建小程序：
	 * 
	 * @author James Guo
	 * @param params:
	 *            创建小程序时所需的参数，传入的参数格式：小程序名,小程序ID,小程序密钥 ；
	 * @param testData：
	 *            null
	 * @throws Exception
	 */
	public void createSmallApp(String stepDescription, String params, String testData, String stepNum) throws Throwable {// params：传递来的以逗号分隔的参数列表，分别是“名称、ID、Key”：
		stepInfo(stepDescription, stepNum);
		// 处理参数：
		String[] param = {};
		try {
			if (StringUtils.isNotBlank(params)) {

				if (params.contains(",")) {
					param = params.split(",");
				} else {
					log.info(ReportUtils.formatError("参数列表格式错误，多参数要以\" , \" 分隔. 参数顺序：小程序名称 - 小程序ID - 小程序密钥"));
					throw new StopRunningException(BaseKeywords.StoppingRunning);
				}
			}
			ApplicationPage ap = new ApplicationPage();
			ap.createSmallApp(param[0], param[1], param[2]);// param[0]=name,//
															// param[1]=id ,//
															// param[2]=key
		} catch (Exception e) {
			takeScreenshot();
			throw new StopRunningException(BaseKeywords.StoppingRunning, e);
		} 
	}

	/**
	 * 
	 * @author James Guo
	 * @param stepDescription:
	 *            步骤信息
	 * @param params：包含[应用名称、应用平台、应用状态、下载链接]
	 * @param testData:
	 *            null
	 * @throws StopRunningException
	 */
	public void createApp(String stepDescription, String params, String testData) throws StopRunningException {
		String[] appParams = params.split(",");

		String appName = appParams[0];
		String platform = appParams[1];
		String appStatus = appParams[2];
		String downloadLink = FrameworkUtil.genRandomDownloadLink();
		// 应用平台类型的Map：
		Map<String, AppPlatformsType> appPlatformMap = new HashMap<>();
		appPlatformMap.put("iso", AppPlatformsType.IOS);
		appPlatformMap.put("android", AppPlatformsType.ANDROID);
		appPlatformMap.put("h5", AppPlatformsType.HTML5);
		appPlatformMap.put("smallApp", AppPlatformsType.SMALLAPP);

		if (appPlatformMap.containsKey(platform.toLowerCase())) {
			// platform =
		}
		ApplicationPage ap = new ApplicationPage();

		// ap.createNewApp(appName, platform, appStatus, downloadLink);
	}

	/**
	 * 根据名称删除单个应用
	 * 
	 * @author James Guo
	 * @param appName：要删除的应用的名称
	 * @param testData：null
	 * @throws StopRunningException
	 */
	public void delSingleApp(String stepDescription, String appName, String testData, String stepNum) throws StopRunningException {
		stepInfo(stepDescription, stepNum);
		try {
			ApplicationPage ap = new ApplicationPage();
			ap.delApplication(appName);
		} catch (Exception e) {
			report(ReportUtils.formatError("删除应用[" + appName + "] 时失败..."));
			takeScreenshot();
			throw new StopRunningException(BaseKeywords.StoppingRunning, e);
		} 
	}

	/**
	 * 批量删除：传入要删除的应用的基名（如传入应用名称的前缀 'ADT-AUTO-TEST'），如果不传参，则意为要全部删除：
	 * 
	 * @author James Guo
	 * @param locator：传入的应用名称的基名（如应用的前缀）
	 * @param testData：null
	 * @throws StopRunningException
	 */
	public void batchDel(String stepDescription, String locator, String testData, String stepNum) throws StopRunningException {// locator
		stepInfo(stepDescription, stepNum);
		ApplicationPage ap = new ApplicationPage();

		try {
			ap.batchDel(locator);
		} catch (Exception e) {
			report(ReportUtils.formatError("删除应用时失败.. " + "[" + e.getMessage() + "]"));
			takeScreenshot();
			throw new StopRunningException(BaseKeywords.StoppingRunning, e);
		} 
	}

	/**
	 * 查找“应用”,
	 * 如果要查找指定具体名字的应用，名字是放在“locator"列中，如果要查找上边步骤创建的应用，则用"testData"列中的变量值从Map中取值；
	 * 
	 * @author James Guo
	 * @param locator：传入一个实际的应用名称，或传入上边步骤查找到的应用时定义的变量名
	 *            ；
	 * @param testData：定义一个变量，用于存储查找到的应用
	 * @throws StopRunningException
	 */
	public void searchApp(String stepDescription, String locator, String testData, String stepNum) throws StopRunningException {
		stepInfo(stepDescription, stepNum);
		WebElement e = null;
		String appName = locator;
		try {
			ApplicationCenterPage ap = new ApplicationCenterPage();// 调用封装好的页面方法；
			if (StringUtils.isNotBlank(locator)) {// 如果“locator”列是有值，就按locator列中的值去查找,String
													// appName = locator;
				e = ap.searchSingleApplication(locator);
			} else if (StringUtils.isNotBlank(testData)) {
				appName = (String) tempValueMap.get(testData);// 如果是查找上边步骤创建的应用
																// ，则用变量名从map中取；
				e = ap.searchSingleApplication(appName);// 调用封装好的页面方法；
			}
			// TODO
			tempValueMap.put(locator, e);
		} catch (Exception t) {
			log.info(ReportUtils.formatError("查询应用失败，请检查，要查询的应用：' "
					+ (StringUtils.isNotEmpty(appName) ? appName : locator) + "' " + t.getMessage()));
			takeScreenshot();
			throw new StopRunningException(StoppingRunning, t);// 查询失败时，不再进行后续操作；
		}
	}

	/**
	 * 获取应用列表：TODO
	 * 
	 * @author James Guo
	 * @param locator
	 * @param testData
	 * @return
	 */
	public List<WebElement> getAppList(String stepDescription, String locator, String testData, String stepNum) {
		stepInfo(stepDescription, stepNum);
		List<WebElement> list = null;
		try {
			DataTable dt = new DataTable(locator);
			list = dt.getTableElements();
			report(ReportUtils.formatError("获取列表信息：[" + locator + "]" + " 共有：" + list.size() + " 条记录。"));
		} catch (Exception e) {
			report(ReportUtils.formatError("获取数据列表失败...[" + locator + "]"));
		}
		return list;
	}
	/** --------------应用CURD相关关键字结束------------- */

	/**
	 * 生成随机的下载链接：
	 * 
	 * @author James Guo
	 * @param locator：null
	 * @param testData:
	 *            定义变量，用于存储生成的下载链接
	 */
	public void createDownloadLink(String stepDescription, String locator, String testData, String stepNum) {
		stepInfo(stepDescription, stepNum);
		String downloadLink = null;
		try {
			downloadLink = FrameworkUtil.genRandomDownloadLink();
			log.info("生成随机的下载链接为：" + wrapSingleQuotes(downloadLink));

			tempValueMap.put(testData, downloadLink);// 存放的时候，Key为Excel中的test_data列的值；
		} catch (Exception e) {
			log.info(ReportUtils.formatError("随机下载链接创建不成功，请检查..." + " -> " + e.getMessage()));
		} 
	}
	/**
	 * ADT 登录系统关键字
	 * @author James Guo
	 * @throws Exception 
	 */
	public void login(String stepDescription, String locator, String testData, String stepNum) throws Exception {
		stepInfo(stepDescription, stepNum);
		log.info("正在登录系统...");
		PerformanceTimer timer = new PerformanceTimer(TestContext.getDomTimeout());

		getWebDriver().navigate().to(TestContext.getServerUrl());
		waitForPageLoad();

		WebElement username = getElement("xpath=" + BasicElementLocators.USERNAME_INPUT_XPATH);
		WebElement password = getElement("xpath=" + BasicElementLocators.PASSWORD_INPUT_XPATH);
		
		BaseFramework.clearAndInput(username, TestContext.getUsername());
		completeWait(100);
		BaseFramework.clearAndInput(password, TestContext.getPassword());
		completeWait(100);
		//login:
		getElement("xpath=" + BasicElementLocators.LOGIN_BUTTON_XPATH).click();
		completeWait(100);
		getElement("xpath=" + BasicElementLocators.APP_LINK_XPATH).click();
		
		boolean isNavigated = isPageNavigated("xpath=" + BasicElementLocators.APPLICATION_CENTER_XPTH);

		//waitForPageNavigated("等待页面跳转...", "xpath=" + BasicElementLocators.APPLICATION_CENTER_XPTH, null);
		if(isNavigated){
			log.info("登录成功, 耗时：" + timer.getElapsedTime() / 1000 + " s");
		}else{
			log.info("登录失败，请检查, 耗时：" + timer.getElapsedTime() / 1000 + " s");
		}
		
	}

	/**
	 * 无论在哪个页面，都返回“产品中心”页面，在一条新用例测试前，先回到“产品中心”页面,无需传值
	 * @author James Guo
	 * @param locator: null
	 * @param testData: null
	 */
	public void back2ApplicationCenterPage(String stepDescription, String locator, String testData, String stepNum) throws Exception {
		stepInfo(stepDescription, stepNum);
		try {
			ApplicationPage ap = new ApplicationPage();
			ap.back2ApplicationCenterPage();
			isPageNavigated("xpath=" + BasicElementLocators.APPLICATION_CENTER_XPTH);

		} catch (Exception e) {
			log.error(ReportUtils.formatError("返回 '产品中心' 页面失败... 原因： " + e.getMessage()));
			takeScreenshot();
			throw new StopRunningException(StoppingRunning, e);
		} 
	}
}
