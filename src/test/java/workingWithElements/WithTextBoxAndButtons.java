package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WithTextBoxAndButtons {

	ChromeDriver driver;

	@Test

	public void LoginScreen() {

		WebElement txt_username = driver.findElement(By.id("username"));
		WebElement txt_password = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.className("radius"));
		txt_username.clear();
		txt_username.sendKeys("tomsmith");
		txt_password.clear();
		txt_password.sendKeys("SuperSecretPassword!");
		btnLogin.click();
		
		WebElement SucessMsg = driver.findElement(By.id("flash"));
		System.out.println(SucessMsg.getText());
		Assert.assertTrue(SucessMsg.getText().contains("You logged into a secure area!"));




	}


	@BeforeTest
	public void OpenURl ()
	{
		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}	

	@AfterTest

	public void CloseDrvier() {
		driver.close();


	}

}
