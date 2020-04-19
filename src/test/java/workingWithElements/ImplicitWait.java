package workingWithElements;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {


	ChromeDriver driver;


	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir") +"\\Sources\\chromedriver.exe" ;
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test

	public void TestImplicitWait () {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Page 4")).click();
		WebElement message = driver.findElement(By.id("page4"));
		assertTrue(message.getText().contains("Nunc nibh tortor"));

	}


	@AfterTest

	public void CloseDriver() {

		driver.close();
	}




}
