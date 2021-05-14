package datadrivenframework.test;

import org.openqa.selenium.WebDriver;

import datadrivenframework.factory.DriverFactory;

public class BaseTest {

	WebDriver driver;

	public WebDriver getDriver() {
		driver = DriverFactory.getDriver();
		return driver;
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
		driver.quit();
	}

	public void waitForSeconds(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
