package datadrivenframework.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import datadrivenframework.factory.DriverFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseTest {

	WebDriver driver;

	public WebDriver getDriver() {
		driver = DriverFactory.getDriver();
		log.info("Test Sarted");
		return driver;
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
		driver.quit();
		log.info("Test Finished");
	}

	public void waitForSeconds(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollWindow(WebDriver driver, int scrollTo) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + scrollTo + ");");
	}

}
