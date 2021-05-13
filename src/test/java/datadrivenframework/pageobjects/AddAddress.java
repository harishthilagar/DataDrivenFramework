package datadrivenframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAddress extends BasePage {
	WebDriver driver;
	public AddAddress(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[text()='New Address']")
	private WebElement newAddress;
	
	@FindBy(xpath="//input[@id='address_first_name']")
	private WebElement firstName;

	@FindBy(xpath="//input[@id='address_last_name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='address_street_address']")
	private WebElement address1;

	@FindBy(xpath="//input[@id='address_city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='address_zip_code']")
	private WebElement zipCode;
	
	@FindBy(css="input[type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement list;
	
	public void newAddress() {
		click(newAddress);
	}
	
	public void firstName(String firstName1) {
		sendKeys(firstName,firstName1);
	}
	public void lastName(String lastName1) {
		sendKeys(lastName,lastName1);
	}
	
	public void address1(String addressValue1) {
		sendKeys(address1,addressValue1);
	}
	
	public void city(String cityValue) {
		sendKeys(city,cityValue);
	}
	
	public void zipCode(String zipCodeValue) {
		sendKeys(zipCode,zipCodeValue);
	}
	
	public void clicksubmit() {
		click(submit);
	}
	
	public void clickList() {
		click(list);
	}
	

}
