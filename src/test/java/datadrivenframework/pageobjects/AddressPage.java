package datadrivenframework.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

	WebDriver driver;

	public AddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Addresses']")
	private WebElement address;


	public void address() {
		click(address);
	}

}
