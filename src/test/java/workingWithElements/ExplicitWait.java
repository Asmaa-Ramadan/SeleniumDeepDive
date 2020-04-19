package workingWithElements;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait {


	ChromeDriver driver;


	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir") +"\\Sources\\chromedriver.exe" ;
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com.eg/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test

	public void TestExplicitWait () {
		WebElement queryTxt = driver.findElement(By.id("lst-ib"));
		queryTxt.sendKeys("selenium webdriver");
		queryTxt.submit();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("selenium"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}


	@AfterTest

	public void CloseDriver() {

		driver.close();
	}




}
