package qafox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id=\"input-email\"]")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@type=\"password\"]")
	private WebElement passwordfield;

	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement loginbutton;

	// constructor (connecting drivers)
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void enteremailpassandclick(String Email, String Password) {
		emailfield.sendKeys(Email);
		passwordfield.sendKeys(Password);
		loginbutton.click();

	}
}
