package datadrivenframework.pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DestroyAddress extends BasePage {

	WebDriver driver;

	public DestroyAddress(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> tableRows;
	
	public void deleteAddress(String firstName,String lastName) {
		deleteAddress(tableRows, driver,firstName,lastName);
	}

	public void deleteAddresses() {
		deleteAllAddress(tableRows, driver);
	}

	public void deleteAddress(List<WebElement> tableRows, WebDriver driver,String firstName,String lastName) {
		if (tableRows.size() > 0) {
			for(int i=0;i<tableRows.size();i++) {
				System.out.println(tableRows.size());
				List<WebElement> tableCol = tableRows.get(i).findElements(By.xpath("./td"));
				if(tableCol.get(0).getText().equals(firstName)&&tableCol.get(1).getText().equals(lastName)) {
					WebElement aTag = tableCol.get(6).findElement(By.xpath("./a"));
					click(aTag);
					wait.until(ExpectedConditions.alertIsPresent());
					Alert alert = driver.switchTo().alert();
					alert.accept();
					i--;
				}
			}
		System.out.println("for loop ends");	
		} else {
			System.out.println("No addresses found");
		}		
	}

	public void deleteAllAddress(List<WebElement> tableRows, WebDriver driver) {
		if (tableRows.size() > 0) {
			int i = 0;
			while (tableRows.size() > 0) {
				List<WebElement> tableCol = tableRows.get(i).findElements(By.xpath("./td"));
				WebElement aTag = tableCol.get(6).findElement(By.xpath("./a"));
				click(aTag);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		} else {
			System.out.println("No addresses found");
		}
	}

}
