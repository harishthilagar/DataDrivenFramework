package datadrivenframework.test;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import datadrivenframework.dataprovider.DataProvider1;
import datadrivenframework.factory.DriverFactory;
import datadrivenframework.factory.PageProvider;
import datadrivenframework.listeners.TestListener;
import datadrivenframework.pageobjects.AddAddress;
import datadrivenframework.pageobjects.AddressPage;
import datadrivenframework.pageobjects.HomePage;
import datadrivenframework.pageobjects.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	WebDriver driver;
	PageProvider provider;
	public static final Logger logger=LogManager.getLogger(LoginTest.class);

	@BeforeClass
	public void setup(ITestContext context) {
        driver = DriverFactory.getDriver();
		provider = new PageProvider(driver);
		context.setAttribute("driver", driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		HomePage homepage = provider.getHomePage();
		homepage.signIn();
		logger.info("login test start");
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

	@Test(dataProvider = "addressDataProvider", dataProviderClass = DataProvider1.class , priority=4)
	public void addAddressTest(LinkedList<String> obj) {
		AddAddress addAddress = provider.addAddress();
		addAddress.newAddress();
		logger.info("new address button clicked");
		addAddress.firstName(obj.get(1));
		addAddress.lastName(obj.get(2));
		addAddress.address1(obj.get(3));
		addAddress.city(obj.get(4));
		addAddress.zipCode(obj.get(5));
		addAddress.clicksubmit();
		logger.info(obj.get(0)+" "+" address added");
		addAddress.clickList();
		waitForSeconds(3);	
	}
	
	@AfterClass
	public void tearDown() {
         closeDriver(driver);
	}

}
