package com.tendcloud.adt.testcases.non_keywords.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tendcloud.adt.framework.constants.BasicElementLocators;

import framework.base.LoggerManager;
import framework.webdriver.TestContext;


public class TestRemoteDriver {
	private static Logger logger = LoggerManager.getLogger(Thread.currentThread().getClass().getName());

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", TestRemoteDriver.class.getClassLoader().getResource("browser-drivers/chromedriver.exe").getPath());

		//WebDriver driver = new FirefoxDriver();
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);*/
		//cap.setPlatform(Platform.WINDOWS);
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new RemoteWebDriver(new URL("http://192.168.234.129:8888/wd/hub/"), cap);
		/*driver.get("http://www.baidu.com/");
		logger.debug("open http://www.baidu.com");
		waitFor();
		driver.findElement(By.id("kw")).sendKeys("hello");
		logger.debug("sent hello to keyword input box");
		waitFor();
		driver.findElement(By.id("su")).click();
		logger.debug("click on submit button");
		waitFor();
		driver.quit();
		logger.debug("quit the webdriver instance");*/
		driver.get("https://www.talkingdata.com");
		
		//driver.get("http://172.20.7.2:10005/webapp/index/login.html");
		System.out.println("登录：" + driver.getWindowHandle() + " - title: " + driver.getTitle());
		
		driver.findElement(By.xpath(BasicElementLocators.USERNAME_INPUT_XPATH)).sendKeys("tracking_dev@tendcloud.com");;
		driver.findElement(By.xpath(BasicElementLocators.PASSWORD_INPUT_XPATH)).sendKeys("ddd");
		waitFor();
		driver.findElement(By.xpath(BasicElementLocators.LOGIN_BUTTON_XPATH)).click();
		
		waitFor();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath(BasicElementLocators.CREATE_NEW_APP_XPATH)));
		*/
		//System.out.println(e.getText());
		//e.click();
		System.out.println(driver);
		waitFor();
		
		/*js.executeScript("arguments[0].click();",
		driver.findElement(By.xpath(BasicElementLocators.GAME_XPATH)));
		*/
		//driver.switchTo().window(driver.getWindowHandle());
		
		
		//WebElement appType = driver.findElement(By.xpath(BasicElementLocators.GAME_XPATH));
		//appType.click();
		
		waitFor();
		
		
		//driver.quit();
	}
	
	private static void waitFor(){
		//int time = TestContext.getDomTimeout();
		int time = 3000;
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
