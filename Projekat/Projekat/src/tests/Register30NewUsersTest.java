package tests;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationSajt.Register30NewUsers;

public class Register30NewUsersTest {
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
		for (int i = 0; i < 30; i++) {
			Register30NewUsers.signIn(driver, i);
			String actual = Register30NewUsers.registerUser(driver, i);
			sa.assertEquals(actual, "My account - My Store");
			Register30NewUsers.logOut(driver);
			sa.assertAll();

		}
	}
}