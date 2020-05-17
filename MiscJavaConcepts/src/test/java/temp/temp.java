package temp;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class temp {
	
	@Test
	public void test() {
		
		String valueToBeSelected = "Monday";
		String selectAnythingButThis = "Tuesday~Please select~Sunday"; //this should never be selected
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Select select = new Select(driver.findElement(By.id("select-demo")));
		
		//Try to select the value, if found then fine and selected end of story
		//If not found, then loop thorugh all the elements and look for 
		//element which should not be selected and select any other random value
		try {
			select.selectByVisibleText(valueToBeSelected);
		}catch(NoSuchElementException e) {
			List<WebElement> list = select.getOptions();
			int counter=0;
			for(WebElement ls:list) {
				if ( !(selectAnythingButThis.contains(ls.getText()))){
					select.selectByIndex(counter);
					break;
				}
				counter = counter + 1;
			}
		}		
	}

}
