package design.pattern.factory.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends WebDriverManager {

	@Override
	public WebDriver initDriver() {
		return new ChromeDriver();
	}

}
