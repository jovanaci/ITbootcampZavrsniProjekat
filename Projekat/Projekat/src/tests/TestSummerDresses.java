package tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationSajt.HomePage;
import automationSajt.summerDresses;

public class TestSummerDresses {
	private static WebDriver driver;

	@BeforeClass
	public void CreateDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}

	@Test
	public void SummerDressFromWomen() {
		driver.get(summerDresses.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		summerDresses.getSummerDressesPage1(driver);

		String str1 = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(str1, expectedUrl);
	}

	@Test
	public void SummerDressFromDress() {
		driver.get(summerDresses.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		summerDresses.getSummerDressesPage2(driver);

		String str2 = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(str2, expectedUrl);
	}

	@Test
	public void compareURLs() {
		driver.get(summerDresses.HOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		summerDresses.getSummerDressesPage1(driver);
		String url1 = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		summerDresses.getSummerDressesPage2(driver);
		String url2 = driver.getCurrentUrl();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(url1, url2);
		sa.assertAll();
	}

}