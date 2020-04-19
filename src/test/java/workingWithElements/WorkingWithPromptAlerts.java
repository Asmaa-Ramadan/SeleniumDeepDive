package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithPromptAlerts {

	ChromeDriver driver;

	@BeforeTest
	public void OpenURL() {

		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}

	@Test

	public void WorkingWithPromptAlert() {

		WebElement TryItButton = driver.findElement(By.id("prompt"));
		TryItButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Asmaa");
		alert.accept();
		WebElement message = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello Asmaa! How are you today?", message.getText());

	}



	@AfterTest

	public void CloseDriver()
	{
		driver.close();
	}

}
