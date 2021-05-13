package datadrivenframework.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import datadrivenframework.factory.DriverFactory;
import datadrivenframework.factory.PageProvider;
import datadrivenframework.pageobjects.AddressPage;
import datadrivenframework.pageobjects.DestroyAddress;
import datadrivenframework.pageobjects.HomePage;
import datadrivenframework.pageobjects.LoginPage;

public class DeleteAddressTest extends BaseTest {

	WebDriver driver;
	PageProvider provider;
	public static final Logger logger = LogManager.getLogger();
	LoginTest login = new LoginTest();

	@BeforeClass
	public void setup() {
		driver = DriverFactory.getDriver();
		provider = new PageProvider(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		HomePage homepage = provider.getHomePage();
		homepage.signIn();
		logger.info("signin button clicked");
	}

	@Test(priority = 2)
	public void signinTest() {
		LoginPage loginPage = provider.getLoginPage();
		loginPage.logIn();
		logger.info("email and password sended and signedin");
	}

	@Test(priority = 3)
	public void addressTest() {
		AddressPage addressPage = provider.getAddressPage();
		addressPage.address();
		logger.info("address button clicked");
		waitForSeconds(3);
	}
	
	@Test(priority = 4)
	public void deleteAddress() {
		DestroyAddress delete = provider.deleteAddress();
//		delete.deleteAddress("firstName1", "lastName1");
		delete.deleteAddresses();
		logger.info("Address deleted");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
