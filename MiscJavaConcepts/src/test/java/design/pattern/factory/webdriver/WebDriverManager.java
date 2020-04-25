package design.pattern.factory.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {

	protected abstract WebDriver initDriver();
	
	public WebDriver getDriver() {
		return initDriver();
	}
}
