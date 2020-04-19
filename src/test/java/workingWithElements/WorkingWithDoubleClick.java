package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDoubleClick {

	ChromeDriver driver;

	@Test
	public void DoubleClick() {
		
		WebElement message = driver.findElement(By.id("message"));
		// To get the CSS value of the existing color 
		System.out.println(message.getCssValue("background-color"));
		// To check the value of the existing color is the required value
		Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		Actions builder = new Actions(driver);
		builder.doubleClick(message).perform();
		// To get the CSS value of the color after clicking
		System.out.println(message.getCssValue("background-color"));
		// To check the value of the CSS color is changed to the required one or not
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
	}



	@BeforeTest
	public void OpenURL() {
		
		String ChromePath = System.getProperty("user.dir")+ "\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}


	@AfterTest
	public  void CloseDriver() {
		driver.close();
	}


}
