package datadrivenframework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import datadrivenframework.factory.PageProvider;
import datadrivenframework.listeners.TestListener;
import datadrivenframework.pageobjects.AddressPage;
import datadrivenframework.pageobjects.DestroyAddress;
import datadrivenframework.pageobjects.HomePage;
import datadrivenframework.pageobjects.LoginPage;
import lombok.extern.slf4j.Slf4j;

@Listeners(TestListener.class)
@Slf4j
public class DeleteAddressTest extends BaseTest {

	WebDriver driver;
	PageProvider provider;
	LoginTest login = new LoginTest();

	@BeforeClass
	public void setup() {
		driver = getDriver();
		provider = new PageProvider(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		HomePage homepage = provider.getHomePage();
		homepage.signIn();
		log.info("signin button clicked");
	}

	@Test(priority = 2)
	public void signinTest() {
		LoginPage loginPage = provider.getLoginPage();
		loginPage.logIn();
		log.info("email and password sended and signedin");
	}

	@Test(priority = 3)
	public void addressTest() {
		AddressPage addressPage = provider.getAddressPage();
		addressPage.address();
		log.info("address button clicked");
		waitForSeconds(3);
	}

	@Test(priority = 4)
	public void deleteAddress() {
		DestroyAddress delete = provider.deleteAddress();
//		delete.deleteAddress("firstName1", "lastName1");
		delete.deleteAddresses();
		log.info("Address deleted");
	}

	@AfterClass
	public void tearDown() {
		closeDriver(driver);
	}

}
