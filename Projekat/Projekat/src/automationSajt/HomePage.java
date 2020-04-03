package automationSajt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static final String HOME_URL = "http://automationpractice.com/index.php";
	
	

	public static void homePage(WebDriver wd) {
		WebElement home = wd.findElement(By.xpath(HOME_URL));
		home.click();
	}
}
