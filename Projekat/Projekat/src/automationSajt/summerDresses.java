package automationSajt;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class summerDresses {

	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public static final String WOMEN_XPATH = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	public static final String SUM_DRESSES_XPATH = "//li[@class='sfHover']//ul//li//a[contains(text(),'Summer Dresses')]";
	public static final String DRESSES_XPATH = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a";
	public static final String SUM_DRESSES_XPATH1 = "//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']//li//a[contains(text(),'Summer Dresses')]";
			
	public static void getSummerDressesPage1(WebDriver driver) {
		WebElement elem = driver.findElement(By.xpath(WOMEN_XPATH));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(elem).perform();
		driver.findElement(By.xpath(SUM_DRESSES_XPATH)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}

	public static void getSummerDressesPage2(WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement elem1 = driver.findElement(By.xpath(DRESSES_XPATH));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		actions.moveToElement(elem1).perform();
		driver.findElement(By.xpath(SUM_DRESSES_XPATH1)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

}
