package datadrivenframework.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import datadrivenframework.constants.UIconstants;
import datadrivenframework.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	static WebDriver driver;

	public static WebDriver getDriver() {
		PropertyReader prop = new PropertyReader();
		String browser = prop.getProperty(UIconstants.BROWSER);
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "chromedebug":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("debuggerAddress", "localhost:9014");
			driver = new ChromeDriver(options);
			break;

		case "headlessChrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("window-size=1920,1080");
			option.addArguments("start-maximized");
			option.addArguments("headless");
			driver = new ChromeDriver(option);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "browserstack":
			ChromeOptions caps = new ChromeOptions();
			caps.addArguments("start-maximized");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "90");
			caps.setCapability("name", "harish's Test");
			try {
				driver = new RemoteWebDriver(new URL(UIconstants.URL), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			driver = null;
			break;
		}
		int wait = Integer.parseInt(prop.getProperty(UIconstants.IMPLICIT_WAIT));
		driver.get(prop.getProperty(UIconstants.BASE_URL));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
