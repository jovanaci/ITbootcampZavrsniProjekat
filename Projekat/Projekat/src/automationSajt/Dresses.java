package automationSajt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Dresses {

	private static final String FIRST_DRESS_XPATH = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]";
	private static final String MORE_XPATH = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[2]/span";
	private static final String AMOUNT_XPATH = "//*[@id=\"quantity_wanted\"]";
	private static final String BLUE_COLOR_XPATH = "//*[@id=\"color_14\"]";
	private static final String SUBMIT_BTN_XPATH = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button";
	private static final String CLOSE_XPATH = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span";
	private static final String QTY_XPATH = "//input[@name='quantity_5_24_0_0']";
	private static final String DRESS_NAME_XPATH = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
	private static final String CART_XPATH= "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a";
	private static final String DRESS_COLOR_XPATH = "//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]";
	
	 
	public static void getHome(WebDriver driver) {
		driver.navigate().to(HomePage.HOME_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public static void buyDress(WebDriver driver) {
		getHome(driver);
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.xpath(summerDresses.WOMEN_XPATH));
		action.moveToElement(elem).perform();
		elem = driver.findElement(By.xpath(summerDresses.SUM_DRESSES_XPATH));
		action.moveToElement(elem).click().perform();
		elem = driver.findElement(By.xpath(FIRST_DRESS_XPATH));
		action.moveToElement(elem).perform();
		elem = driver.findElement(By.xpath(MORE_XPATH));
		elem.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		elem = driver.findElement(By.xpath(AMOUNT_XPATH));
		elem.click();
		elem.sendKeys(Keys.BACK_SPACE);
		elem.sendKeys("2");
		elem = driver.findElement(By.id("group_1"));
		elem.click();
		elem = driver.findElement(By.xpath("//option[contains(text(),'M')]"));
		elem.click();
		elem = driver.findElement(By.xpath(BLUE_COLOR_XPATH));
		elem.click();
		elem = driver.findElement(By.xpath(SUBMIT_BTN_XPATH));
		elem.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		elem = driver.findElement(By.xpath(CLOSE_XPATH));
		elem.click();
	}
	
	public static void getCart(WebDriver driver) {
		WebElement elem = driver.findElement(By.xpath(CART_XPATH));
		elem.click();
	}
	
	public static String dressQuantity(WebDriver driver) {
		buyDress(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		getCart(driver);
		WebElement elem = driver.findElement(By.xpath(QTY_XPATH));
		String qty =  elem.getAttribute("value");
		return qty;
	}
	
	public static String dressName(WebDriver driver) {
		buyDress(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		getCart(driver);
		WebElement elem = driver.findElement(By.xpath(DRESS_NAME_XPATH));
		String name = elem.getText();
		return name;
	}
	
	public static String dressColor(WebDriver driver) {
		buyDress(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		getCart(driver);
		WebElement elem = driver.findElement(By.xpath(DRESS_COLOR_XPATH));
		String [] details = elem.getText().split(" ");
		String color = details[2].replace(",","");
		return color;
	}
	
	public static String dressSizeM(WebDriver driver) {
		buyDress(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		getCart(driver);
		WebElement elem = driver.findElement(By.xpath(DRESS_COLOR_XPATH));
		String [] details = elem.getText().split(" ");
		String size = details[5];
		return size;
	}
	
	
}
