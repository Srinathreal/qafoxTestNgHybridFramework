package qafoxtestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qafox.base.Base;
import qafox.pages.AccountPage;
import qafox.pages.HomePage;
import qafox.pages.LoginPage;
import qafox.utils.Utilities;

public class Login extends Base {

	public Login() throws IOException {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowser(prop.getProperty("browsername"));
		HomePage homepage = new HomePage(driver); // creating object
		homepage.navigatetoAccountpage();
	}

	@Test(dataProvider = "ExcelTestData")
	public void login(String Email, String Password) {

		// using pom and datadriven method

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteremailpassandclick(Email, Password);

		// datadriven method
		/*
		 * driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(Email);
		 * driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(
		 * Password);
		 */

		// prop method
		/*
		 * driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(prop.
		 * getProperty(Email));
		 * driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(prop
		 * .getProperty(Password));
		 */

		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplaystatusOfAccountPage(), "AccountPageNotDisplayed");
		takeScreenshot("S5.png");
	}

	@DataProvider(name = "ExcelTestData")
	public Object[][] supplyTestData() throws IOException {
		Object[][] data = Utilities.getDataFromExcel("LoginSheet");
		return data;
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
