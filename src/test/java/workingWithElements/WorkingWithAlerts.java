package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithAlerts {

	ChromeDriver driver;

	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}

	@Test

	public void WorkingWithAlert() {
		WebElement ShowAlert = driver.findElement(By.id("simple"));

		ShowAlert.click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals("Hello! I am an alert box!", alertText);
		alert.accept();

	}



	@AfterTest

	public void CloseDriver()
	{
		driver.close();
	}

}
