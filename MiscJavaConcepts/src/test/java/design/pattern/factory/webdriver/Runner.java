package design.pattern.factory.webdriver;

import org.openqa.selenium.WebDriver;

public class Runner {

	public static void main(String[] args) throws Exception {
		WebDriverManager webDriverManager = WebDriverFactory.getManager("chrome");
		WebDriver driver = webDriverManager.getDriver();
		
	}
}
