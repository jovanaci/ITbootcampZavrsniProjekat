package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import automationSajt.LogIn30Users;
import automationSajt.Register30NewUsers;

public class TestLogin30Users {
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
	public void testLoginUser() {
		for (int i = 0; i < 30; i++) {
			String actual = LogIn30Users.loginUser(driver, i);
			sa.assertEquals(actual, "My account - My Store");
			Register30NewUsers.logOut(driver);
			sa.assertAll();

		}

	}
}
