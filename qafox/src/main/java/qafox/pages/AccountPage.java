package qafox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Qafox.com")
	private WebElement accountPageVerify;

	public boolean getDisplaystatusOfAccountPage() {
		boolean displayed = accountPageVerify.isDisplayed();
		return displayed;
	}

}
