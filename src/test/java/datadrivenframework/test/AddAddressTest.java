package datadrivenframework.test;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import datadrivenframework.dataprovider.DataProvider1;
import datadrivenframework.factory.PageProvider;
import datadrivenframework.listeners.TestListener;
import datadrivenframework.testMethods.TestMethods;

@Listeners(TestListener.class)
public class AddAddressTest extends BaseTest {
	WebDriver driver;
	PageProvider provider;
	TestMethods testMethod = new TestMethods();
	public static final Logger logger = LogManager.getLogger(AddAddressTest.class);

	@BeforeClass
	public void setup(ITestContext context) {
		driver = getDriver();
		provider = new PageProvider(driver);
		context.setAttribute("driver", driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		testMethod.signInBtn(provider);
	}

	@Test(priority = 2)
	public void signinTest() {
		testMethod.signIn(provider);
	}

	@Test(priority = 3)
	public void addressTest() {
		testMethod.addressBtn(provider);
	}

	@Test(dataProvider = "addressDataProvider", dataProviderClass = DataProvider1.class, priority = 4)
	public void addAddressTest(LinkedList<String> obj) {
		testMethod.addAddress(obj, provider, driver);
	}

	@AfterClass
	public void tearDown() {
		closeDriver(driver);
	}

}
