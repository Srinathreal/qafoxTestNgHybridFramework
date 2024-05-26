package qafox.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	public Properties prop;

	public Base() throws IOException {

		prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "/src/main/java/qafox/config/config.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
	}

	public WebDriver initializeBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(qafox.utils.Utilities.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(qafox.utils.Utilities.PAGE_LOAD));
		driver.get(prop.getProperty("url"));

		return driver;
	}

	public void takeScreenshot(String fileName) {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File (System.getProperty("user.dir") + "/Snaps/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	
}
}
