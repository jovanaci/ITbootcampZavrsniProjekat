package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationSajt.Dresses;

public class DressesTest {
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
	public void testQty() {
		String actual = Dresses.dressQuantity(driver);
		sa.assertEquals(actual, "2");
		sa.assertAll();
	}
	
	@Test
	public void testName() {
		String actual = Dresses.dressName(driver);
		sa.assertEquals(actual, "Printed Summer Dress");
		sa.assertAll();
	}
	
	@Test
	public void testColor() {
		String actual = Dresses.dressColor(driver);
		sa.assertEquals(actual, "Blue");
		sa.assertAll();
	}
	
	@Test
	public void testSize() {
		String actual = Dresses.dressSizeM(driver);
		sa.assertEquals(actual, "M");
		sa.assertAll();
	}
}