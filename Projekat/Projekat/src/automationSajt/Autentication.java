package automationSajt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Autentication {
	
	private static final String TO_CHECKOUT_XPATH = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	private static final String EMAIL_XPATH = "//input[@id='email_create']";
	private static final String SUBMIT_BTN_XPATH = "//button[@id='SubmitCreate']";
	private static final String MR_RADIO_XPATH = "//*[@id=\"id_gender1\"]";
	private static final String MRS_RADIO_XPATH = "//*[@id=\"id_gender2\"]";
	private static final String FIRST_NAME_XPATH = "//input[@id='customer_firstname']";
	private static final String LAST_NAME_XPATH = "//input[@id='customer_lastname']";
	private static final String PASS_XPATH = "//input[@id='passwd']";
	private static final String NEWSLETTER_XPATH = "//input[@id='newsletter']";
	private static final String SPEC_OFF_XPATH = "//input[@id='optin']";
	private static final String ADDRESS_XPATH = "//input[@id='address1']";
	private static final String CITY_XPATH = "//input[@id='city']";
	private static final String STATE_XPATH = "//select[@id='id_state']";
	private static final String ZIP_XPATH = "//input[@id='postcode']";
	private static final String PHONE_XPATH = "//input[@id='phone_mobile']";
	private static final String ALIAS_XPATH = "//input[@id='alias']";
	private static final String REGISTER_XPATH = "//span[contains(text(),'Register')]";
	private static final String SINGNOUT_XPATH = "//a[@class='logout']";
	private static final String SIGNIN_XPATH = "//a[@class='login']";
	private static final String EMAIL_LOGIN_XPATH = "//input[@id='email']";
	private static final String PASS_LOGIN_XPATH = "//input[@id='passwd']";
	private static final String SIGNIIN_XPATH = "//p[@class='submit']//span[1]";

	
	public static String registerNewUser(WebDriver driver, String email, String gender, String firstName, String lastName,
			String pass, String address, String city, String zip, String state, String phone, String alt) {
		Dresses.buyDress(driver);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Dresses.getCart(driver);
		driver.findElement(By.xpath(TO_CHECKOUT_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EMAIL_XPATH)).sendKeys(email);
		driver.findElement(By.xpath(SUBMIT_BTN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.xpath(MRS_RADIO_XPATH));
		gender = gender.toLowerCase();
		if (gender.equals("female")) {
			driver.findElement(By.xpath(MRS_RADIO_XPATH)).click();
		} else if (gender.equals("male")) {
			driver.findElement(By.xpath(MR_RADIO_XPATH)).click();
		}
		driver.findElement(By.xpath(FIRST_NAME_XPATH)).sendKeys(firstName);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(LAST_NAME_XPATH)).sendKeys(lastName);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PASS_XPATH)).sendKeys(pass);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sleep();
		driver.findElement(By.xpath(NEWSLETTER_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SPEC_OFF_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ADDRESS_XPATH)).sendKeys(address);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CITY_XPATH)).sendKeys(city);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		elem = driver.findElement(By.xpath(STATE_XPATH));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select State = new Select(elem);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		State.selectByVisibleText(state);
		driver.findElement(By.xpath(ZIP_XPATH)).sendKeys(zip);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PHONE_XPATH)).sendKeys(phone);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ALIAS_XPATH)).clear();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ALIAS_XPATH)).sendKeys(alt);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(REGISTER_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SINGNOUT_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SIGNIN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(email);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PASS_LOGIN_XPATH)).sendKeys(pass);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SIGNIIN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.getTitle();
	}

	private static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}