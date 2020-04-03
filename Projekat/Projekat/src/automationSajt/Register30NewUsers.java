package automationSajt;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.media.sound.InvalidFormatException;
import org.openqa.selenium.support.ui.Select;

public class Register30NewUsers {

	private static final String HOME_URL = "http://automationpractice.com/index.php";
	private static final String LOGIN_XPATH = "//a[@class='login']";
	private static final String EMAIL_XPATH = "//input[@id='email_create']";
	private static final String SUBMIT_BTN_XPATH = "//button[@id='SubmitCreate']";
	private static final String FIRST_NAME_XPATH = "//input[@id='customer_firstname']";
	private static final String LAST_NAME_XPATH = "//input[@id='customer_lastname']";
	private static final String PASS_XPATH = "//input[@id='passwd']";
	private static final String ADDRESS_XPATH = "//input[@id='address1']";
	private static final String ADDRESS_CITY_XPATH = "//input[@id='city']";
	private static final String ADDRESS_STATE_XPATH = "//select[@id='id_state']";
	private static final String ZIP_XPATH = "//input[@id='postcode']";
	private static final String PHONE_XPATH = "//input[@id='phone_mobile']";
	private static final String ALIAS_XPATH = "//input[@id='alias']";
	private static final String REGISTER_XPATH = "//span[contains(text(),'Register')]";
	private static final String SINGNOUT_XPATH = "//a[@class='logout']";
	private static final String SIGNIN_XPATH = "//a[@class='login']";
	private static final String EMAIL_LOGIN_XPATH = "//input[@id='email']";
	private static final String PASS_LOGIN_XPATH = "//input[@id='passdriver']";
	private static final String SIGNIIN_XPATH = "//p[@class='submit']//span[1]";

	public static String getData(int i, int j) {
		FileInputStream fi;
		XSSFWorkbook wb;
		try {
			fi = new FileInputStream("Users.xlsx");
			wb = new XSSFWorkbook(fi);
			return wb.getSheetAt(0).getRow(i).getCell(j).toString();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			
			e.printStackTrace();
			return "";
		}
	}

	public static void signIn(WebDriver driver, int i) {
		driver.navigate().to(HOME_URL);
		driver.manage().window().maximize();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(LOGIN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EMAIL_XPATH)).sendKeys(getData(i, 0));
	}

	public static String registerUser(WebDriver driver, int i) {

		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SUBMIT_BTN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(FIRST_NAME_XPATH)).sendKeys(getData(i, 1));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(LAST_NAME_XPATH)).sendKeys(getData(i, 2));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PASS_XPATH)).sendKeys(getData(i, 3));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ADDRESS_XPATH)).sendKeys(getData(i, 4));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ADDRESS_CITY_XPATH)).sendKeys(getData(i, 5));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.xpath(ADDRESS_STATE_XPATH));
		Select State = new Select(elem);
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		State.selectByVisibleText(getData(i, 7));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ZIP_XPATH)).sendKeys(getData(i, 6));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PHONE_XPATH)).sendKeys(getData(i, 8));
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ALIAS_XPATH)).clear();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ALIAS_XPATH)).sendKeys(getData(i, 9));
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
		driver.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(getData(i, 0));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PASS_LOGIN_XPATH)).sendKeys(getData(i, 3));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(SIGNIIN_XPATH)).click();
		sleep();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.getTitle();
	}

	public static void logOut(WebDriver driver) {
		driver.findElement(By.xpath(SINGNOUT_XPATH)).click();
	}

	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}

}