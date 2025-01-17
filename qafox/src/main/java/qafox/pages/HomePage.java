package qafox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath = "//a[@title=\"My Account\"]")
	private WebElement myAccountDropmenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	// constructor (connecting drivers)
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void navigatetoAccountpage() {
		myAccountDropmenu.click();
		loginOption.click();
	}

}
