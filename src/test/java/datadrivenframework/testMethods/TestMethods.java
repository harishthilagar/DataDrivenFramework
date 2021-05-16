package datadrivenframework.testMethods;

import java.util.LinkedList;

import org.openqa.selenium.WebDriver;

import datadrivenframework.factory.PageProvider;
import datadrivenframework.pageobjects.AddAddress;
import datadrivenframework.pageobjects.AddressPage;
import datadrivenframework.pageobjects.DestroyAddress;
import datadrivenframework.pageobjects.HomePage;
import datadrivenframework.pageobjects.LoginPage;
import datadrivenframework.test.BaseTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMethods extends BaseTest{

	public void signInBtn(PageProvider provider) {
		HomePage homepage = provider.getHomePage();
		homepage.signIn();
		log.info("signin button clicked");
	}

	public void signIn(PageProvider provider) {
		LoginPage loginPage = provider.getLoginPage();
		loginPage.logIn();
		log.info("email and password sended and signedin");
	}

	public void addressBtn(PageProvider provider) {
		AddressPage addressPage = provider.getAddressPage();
		addressPage.address();
		log.info("address button clicked");
	}
	
	public void addAddress(LinkedList<String> obj,PageProvider provider,WebDriver driver) {
		AddAddress addAddress = provider.addAddress();
		addAddress.newAddress();
		log.info("new address button clicked");
		addAddress.firstName(obj.get(1));
		addAddress.lastName(obj.get(2));
		addAddress.address1(obj.get(3));
		addAddress.city(obj.get(4));
		addAddress.zipCode(obj.get(5));
		scrollWindow(driver, 700);
		addAddress.clicksubmit();
		log.info(obj.get(0) + " " + " address added");
		scrollWindow(driver, 700);
		addAddress.clickList();
		waitForSeconds(3);
	}

	public void deleteAddress(PageProvider provider) {
		DestroyAddress delete = provider.deleteAddress();
//		delete.deleteAddress("firstName1", "lastName1");
		delete.deleteAddresses();
		log.info("Address deleted");
	}
}
