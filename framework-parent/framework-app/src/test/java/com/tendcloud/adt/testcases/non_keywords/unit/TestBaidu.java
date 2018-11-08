package com.tendcloud.adt.testcases.non_keywords.unit;

import static framework.base.Validate.*;
import static framework.base.Verify.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tendcloud.adt.framework.base.AdtTestBase;

import framework.base.LoggerManager;
import framework.webdriver.TestNGListener;

//@Listeners(TestNGListener.class)
public class TestBaidu extends AdtTestBase{
	Logger logger = LoggerManager.getLogger(this.getClass().getSimpleName());

	WebDriver driver = null;
	@Test
	public void testBaidu(){
		driver = getWebDriver();
		
		driver.get("http://www.baidu.com");
		stepInfo("打开 百度 ");
		waitForPageLoad();
		
		WebElement e = driver.findElement(By.xpath("//*[@id='kw']"));
		stepInfo("找到搜索框");
		waitFor(100);
		e.sendKeys("腾云天下");
		logger.info("在搜索框中输入' 腾云天下 ' ");
		WebElement e2 = driver.findElement(By.xpath("//*[@id='su']"));
		stepInfo("点击搜索按钮");
		waitFor(2000);
		
		e2.submit();
		
		List<WebElement> resultList = driver.findElements(By.xpath("//div[@class='result c-container']|//div[@class='result c-container ']"));
		waitFor(1000);
		
		logger.info("找到的结果：'" + resultList.size() + "' 个");

		verifyEquals(resultList.size(), 10, "期望10条结果通过");;
		
		validateBetween(3, 1, 5, "通过");
		
		
	}
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
