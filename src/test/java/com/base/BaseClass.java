package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("enter valid browserType");
			break;
		}
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void enterTextUsingJS(WebElement element, String attribute, String name) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attribute + "','" + name + "')",
				element);
	}

	public static void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static String getPropertyFileValue(String key) throws Throwable, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "//Properties/Config.property")));
		return properties.getProperty(key);
	}

	public static void selectByText(WebElement element, String name) {
		new Select(element).selectByVisibleText(name);
	}

	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\sanja\\eclipse-workspace\\K-nila\\Screenshot\\" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dest);
	}
}