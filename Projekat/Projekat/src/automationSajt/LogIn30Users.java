package automationSajt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LogIn30Users {
	
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
		private static final String PASS_LOGIN_XPATH = "//input[@id='passwd']";
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

		public static String loginUser(WebDriver wd, int i) {
			wd.navigate().to(HOME_URL);
			wd.manage().window().maximize();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(LOGIN_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(getData(i, 0));
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(PASS_LOGIN_XPATH)).sendKeys(getData(i, 3));
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(SIGNIIN_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return wd.getTitle();
		}

		public static String registerUser(WebDriver wd, int i) {

			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(SUBMIT_BTN_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(FIRST_NAME_XPATH)).sendKeys(getData(i, 1));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(LAST_NAME_XPATH)).sendKeys(getData(i, 2));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(PASS_XPATH)).sendKeys(getData(i, 3));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(ADDRESS_XPATH)).sendKeys(getData(i, 4));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(ADDRESS_CITY_XPATH)).sendKeys(getData(i, 5));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement elem = wd.findElement(By.xpath(ADDRESS_STATE_XPATH));
			Select State = new Select(elem);
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			State.selectByVisibleText(getData(i, 7));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(ZIP_XPATH)).sendKeys(getData(i, 6));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(PHONE_XPATH)).sendKeys(getData(i, 8));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(ALIAS_XPATH)).clear();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(ALIAS_XPATH)).sendKeys(getData(i, 9));
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(REGISTER_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(SINGNOUT_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(SIGNIN_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(getData(i, 0));
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(PASS_LOGIN_XPATH)).sendKeys(getData(i, 3));
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			wd.findElement(By.xpath(SIGNIIN_XPATH)).click();
			sleep();
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return wd.getTitle();
		}

		public static void logOut(WebDriver wd) {
			wd.findElement(By.xpath(SINGNOUT_XPATH)).click();
		}

		public static void sleep() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}
