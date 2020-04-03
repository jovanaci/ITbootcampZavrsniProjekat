package tests;

import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationSajt.Autentication;

public class AutenticationTest {
	private static WebDriver driver;
	SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

	@Test
	public void testRegisterUser() {
		String actual = Autentication.registerNewUser(driver, "jovvvvvaaana.cirovicccccc.bu@yahoo.com", "Female", "Jovana", "Cirovic",
				"2255487", "Pere Perica 8", "Beograd", "11000", "Alabama", "1254785", "Zike Zikica 2");
		sa.assertEquals(actual, "My account - My Store");
		sa.assertAll();
	}

}
  