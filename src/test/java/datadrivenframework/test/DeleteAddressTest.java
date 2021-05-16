package datadrivenframework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import datadrivenframework.factory.PageProvider;
import datadrivenframework.listeners.TestListener;
import datadrivenframework.testMethods.TestMethods;
import lombok.extern.slf4j.Slf4j;

@Listeners(TestListener.class)
@Slf4j
public class DeleteAddressTest extends BaseTest {

	WebDriver driver;
	PageProvider provider;
	TestMethods testMethod = new TestMethods();

	@BeforeClass
	public void setup() {
		driver = getDriver();
		provider = new PageProvider(driver);
	}

	@Test(priority = 1)
	public void logIn() {
		testMethod.signInBtn(provider);
	}

	@Test(priority = 2)
	public void signIn() {
		testMethod.signIn(provider);
	}

	@Test(priority = 3)
	public void addressTest() {
		testMethod.addressBtn(provider);
	}

	@Test(priority = 4)
	public void deleteAddressTest() {
		testMethod.deleteAddress(provider);
	}

	@AfterClass
	public void tearDown() {
		closeDriver(driver);
	}

}
