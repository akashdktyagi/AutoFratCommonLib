package design.pattern.factory.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager extends ChromeDriverManager {
	
	@Override
	public WebDriver initDriver() {
		return new FirefoxDriver();
	}
}
